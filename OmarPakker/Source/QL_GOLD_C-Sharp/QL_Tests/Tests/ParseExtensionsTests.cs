using System;
using System.Globalization;
using System.IO;
using System.Reflection;
using Algebra.QL.Extensions.Grammar;
using QL_Tests.Expr;
using QL_Tests.Factory;
using QL_Tests.Stmnt;
using QL_Tests.Type;
using Xunit;

namespace QL_Tests.Tests
{
    public class ParseExtensionsTests
    {
        private ExtParser<ITestStmnt, ITestExpr, ITestType, TestFactory> parser;

        public ParseExtensionsTests()
        {
            parser = new ExtParser<ITestStmnt, ITestExpr, ITestType, TestFactory>(new TestFactory());
            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Extensions.Grammar.QL_Grammar.egt")));
        }

        [Fact]
        public void InstantiatesModulo()
        {
            parser.OnCompletion += (root) =>
            {
                FormStmnt tree = new FormStmnt("Form1",
                    new TextExprStmnt("\"Question 1:\"",
                        new BinaryExpr(
                            new LiteralExpr<int>(5),
                            new LiteralExpr<int>(2)
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
                    new TextExprStmnt("\"Question 1:\"",
                        new BinaryExpr(
                            new LiteralExpr<int>(5),
                            new LiteralExpr<int>(2)
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
                    new TextExprStmnt("\"Question 1:\"",
                        new VarInitExpr("myDate",
                            new BaseType<DateTime>(),
                            new LiteralExpr<object>(0)
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
                    new TextExprStmnt("\"Question 1:\"",
                        new LiteralExpr<DateTime>(DateTime.Parse("2014-02-20T22:00:00Z", CultureInfo.InvariantCulture))
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
