using System;
using System.Globalization;
using System.IO;
using System.Reflection;
using Algebra.QL.Extensions.Grammar;
using Algebra.QL.Extensions.TypeCheck.Expr;
using Algebra.QL.Extensions.TypeCheck.Expr.Literals;
using Algebra.QL.Extensions.TypeCheck.Factory;
using Algebra.QL.Extensions.TypeCheck.Type;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Expr.Literals;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;
using Xunit;

namespace QL_Tests
{
    public class ExtensionsTest
    {
        private ExtensionsParser<ITypeCheckExpr, ITypeCheckStmnt, ITypeCheckType, QLTypeCheckExtensionsFactory> parser;

        public ExtensionsTest()
        {
            parser = new ExtensionsParser<ITypeCheckExpr, ITypeCheckStmnt, ITypeCheckType, QLTypeCheckExtensionsFactory>(new QLTypeCheckExtensionsFactory());
            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Extensions.Grammar.QL_Grammar.egt")));
        }

        [Fact]
        public void InstantiatesModulo()
        {
            parser.OnCompletion += (root) =>
            {
                FormStmnt tree = new FormStmnt("Form1",
                    new LabelStmnt("\"Question 1:\"",
                        new ModuloExpr(
                            new IntLiteral(5),
                            new IntLiteral(2)
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
                    new LabelStmnt("\"Question 1:\"",
                        new PowerExpr(
                            new IntLiteral(5),
                            new IntLiteral(2)
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
                    new QuestionStmnt("\"Question 1:\"",
                        new VarInitExpr("myDate",
                            new DateType(),
                            new DateLiteral(DateTime.MinValue)
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
                    new LabelStmnt("\"Question 1:\"",
                        new DateLiteral(DateTime.Parse("2014-02-20T22:00:00Z", CultureInfo.InvariantCulture))
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
