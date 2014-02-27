using System.IO;
using System.Reflection;
using System.Text;
using Algebra.QL.Core.Grammar;
using QL_Tests.Expr;
using QL_Tests.Factory;
using QL_Tests.Stmnt;
using QL_Tests.Type;
using Xunit;

namespace QL_Tests.Tests
{
	public class ParseTests
	{
        private QLParser<ITestExpr, ITestStmnt, ITestType, TestFactory> parser;

		public ParseTests()
		{
            parser = new QLParser<ITestExpr, ITestStmnt, ITestType, TestFactory>(new TestFactory());

            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Core.Grammar.QL_Grammar.egt")));
		}

		[Fact]
		public void AddAssociation()
		{
			parser.OnCompletion += (root) =>
			{
				FormStmnt tree = new FormStmnt("Form1",
                    new TextExprStmnt("\"Question 1:\"",
						new BinaryExpr(
							new BinaryExpr(
								new LiteralExpr<int>(5),
								new LiteralExpr<int>(2)
                            ),
							new LiteralExpr<int>(4)
						)
					)
				);
				Assert.NotNull(root);
				Assert.Equal(root, tree);
			};
			
			bool parseOk = parser.Parse("form Form1 { \"Question 1:\" << 5 + 2 + 4; }");
			Assert.True(parseOk);
		}

		[Fact]
		public void MultiplicationPrecedence()
		{
			parser.OnCompletion += (root) =>
			{
				FormStmnt tree = new FormStmnt("Form1",
					new TextExprStmnt("\"Question 1:\"",
						new BinaryExpr(
                            new BinaryExpr(
                                new LiteralExpr<int>(2),
							    new LiteralExpr<int>(5)
                            ),
							new BinaryExpr(
								new LiteralExpr<int>(2),
								new LiteralExpr<int>(4)
							)
						)
					)
				);
				Assert.NotNull(root);
				Assert.Equal(root, tree);
			};

			bool parseOk = parser.Parse("form Form1 { \"Question 1:\" << 2 * 5 + 2 * 4; }");
			Assert.True(parseOk);
		}

        [Fact]
        public void CompStmntNestingRightHand()
        {
            parser.OnCompletion += (root) =>
            {
                FormStmnt tree = new FormStmnt("Form1",
                    new CompStmnt(
                        new TextExprStmnt("\"Question 1:\"",
                            new LiteralExpr<int>(5)
                        ),
                        new CompStmnt(
                            new TextExprStmnt("\"Question 1:\"",
                                new LiteralExpr<int>(5)
                            ),
                            new CompStmnt(
                                new TextExprStmnt("\"Question 1:\"",
                                    new LiteralExpr<int>(5)
                                ),
                                new TextExprStmnt("\"Question 1:\"",
                                    new LiteralExpr<int>(5)
                                )
                            )
                        )
                    )
                );
                Assert.NotNull(root);
                Assert.Equal(root, tree);
            };

            bool parseOk = parser.Parse(new StringBuilder().AppendLine("form Form1 {")
                .AppendLine("\"Question 1:\" << 5;")
                .AppendLine("\"Question 1:\" << 5;")
                .AppendLine("\"Question 1:\" << 5;")
                .AppendLine("\"Question 1:\" << 5;")
                .AppendLine("}").ToString());

            Assert.True(parseOk);
        }

        //[Fact]
        //public void CompStmntFlattened()
        //{
        //    parser.OnCompletion += (root) =>
        //    {
        //        FormStmnt tree = new FormStmnt("Form1",
        //            new CompStmnt(
        //                new TextExprStmnt("\"Question 1:\"",
        //                    new LiteralExpr<int>(5)
        //                ),
        //                new TextExprStmnt("\"Question 1:\"",
        //                    new LiteralExpr<int>(5)
        //                ),
        //                new TextExprStmnt("\"Question 1:\"",
        //                    new LiteralExpr<int>(5)
        //                ),
        //                new TextExprStmnt("\"Question 1:\"",
        //                    new LiteralExpr<int>(5)
        //                )
        //            )
        //        );
        //        Assert.NotNull(root);
        //        Assert.Equal(root, tree);
        //    };

        //    bool parseOk = parser.Parse(new StringBuilder().AppendLine("form Form1 {")
        //        .AppendLine("\"Question 1:\" << 5;")
        //        .AppendLine("\"Question 1:\" << 5;")
        //        .AppendLine("\"Question 1:\" << 5;")
        //        .AppendLine("\"Question 1:\" << 5;")
        //        .AppendLine("}").ToString());

        //    Assert.True(parseOk);
        //}

        [Fact]
        public void AssociatesElseCorrectly()
        {
            parser.OnCompletion += (root) =>
            {
                FormStmnt tree = new FormStmnt("Form1",
                    new IfStmnt(
                        new LiteralExpr<bool>(true),
                        new IfElseStmnt(
                            new LiteralExpr<bool>(false),
                            new TextExprStmnt("\"Question 1:\"",
                                new LiteralExpr<int>(7)
                            ),
                            new TextExprStmnt("\"Question 2:\"",
                                new LiteralExpr<int>(13)
                            )
                        )
                    )
                );
                Assert.NotNull(root);
                Assert.Equal(root, tree);
            };

            bool parseOk = parser.Parse(new StringBuilder().AppendLine("form Form1 {")
                .AppendLine("if (true)")
                .AppendLine("if (false)")
                .AppendLine("\"Question 1:\" << 7;")
                .AppendLine("else")
                .AppendLine("\"Question 2:\" << 13;")
                .AppendLine("}").ToString());

            Assert.True(parseOk);
        }
	}
}
