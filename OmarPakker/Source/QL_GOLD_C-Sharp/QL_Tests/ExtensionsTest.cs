using System;
using System.Globalization;
using System.IO;
using System.Reflection;
using Algebra.QL.Core.Value;
using Algebra.QL.Extensions.Factory;
using Algebra.QL.Extensions.Grammar;
using Algebra.QL.Extensions.Type;
using Algebra.QL.Extensions.TypeCheck.Expr;
using Algebra.QL.Extensions.TypeCheck.Factory;
using Algebra.QL.Extensions.Value;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Stmnt;
using Xunit;

namespace QL_Tests
{
    public class ExtensionsTest
    {
        private ExtensionsParser<ITypeCheckExpr, ITypeCheckStmnt, QLExtensionsTypeFactory, QLTypeCheckExtensionsFactory> parser;

        public ExtensionsTest()
        {
            parser = new ExtensionsParser<ITypeCheckExpr, ITypeCheckStmnt, QLExtensionsTypeFactory,
                QLTypeCheckExtensionsFactory>(new QLExtensionsTypeFactory(), new QLTypeCheckExtensionsFactory());
            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Extensions.Grammar.QL_Grammar.egt")));
        }

        [Fact]
        public void InstantiatesModulo()
        {
            parser.OnCompletion += (root) =>
            {
                FormStmnt tree = new FormStmnt("Form1",
                    new QuestionStmnt("\"Question 1:\"", false,
                        new ModuloExpr(
                            new LiteralExpr(new IntValue(5)),
                            new LiteralExpr(new IntValue(2))
                        )
                    )
                );
                Assert.NotNull(root);
                Assert.Equal(root, tree);
            };

            bool parseOk = parser.Parse("form Form1 { \"Question 1:\" << 5 % 2; }");
            Assert.True(parseOk);
        }

        [Fact]
        public void InstantiatesPower()
        {
            parser.OnCompletion += (root) =>
            {
                FormStmnt tree = new FormStmnt("Form1",
                    new QuestionStmnt("\"Question 1:\"", false,
                        new PowerExpr(
                            new LiteralExpr(new IntValue(5)),
                            new LiteralExpr(new IntValue(2))
                        )
                    )
                );
                Assert.NotNull(root);
                Assert.Equal(root, tree);
            };

            bool parseOk = parser.Parse("form Form1 { \"Question 1:\" << 5 ^ 2; }");
            Assert.True(parseOk);
        }

        [Fact]
        public void InstantiatesDateType()
        {
            parser.OnCompletion += (root) =>
            {
                FormStmnt tree = new FormStmnt("Form1",
                    new QuestionStmnt("\"Question 1:\"", true,
                        new VarInitExpr("myDate",
                            new DateType(),
                            new LiteralExpr(new DateValue())
                        )
                    )
                );
                Assert.NotNull(root);
                Assert.Equal(root, tree);
            };

            bool parseOk = parser.Parse("form Form1 { \"Question 1:\" >> myDate:date; }");
            Assert.True(parseOk);
        }

        [Fact]
        public void InstantiatesDate()
        {
            parser.OnCompletion += (root) =>
            {
                FormStmnt tree = new FormStmnt("Form1",
                    new QuestionStmnt("\"Question 1:\"", false,
                        new LiteralExpr(new DateValue(DateTime.Parse("2014-02-20T22:00:00Z", CultureInfo.InvariantCulture)))
                    )
                );
                Assert.NotNull(root);
                Assert.Equal(root, tree);
            };

            bool parseOk = parser.Parse("form Form1 { \"Question 1:\" << 2014-02-20T22:00:00Z; }");
            Assert.True(parseOk);
        }
    }
}
