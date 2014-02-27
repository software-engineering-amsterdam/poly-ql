using System.IO;
using System.Reflection;
using System.Text;
using Algebra.QL.Core.Grammar;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Expr.Literals;
using Algebra.QL.TypeCheck.Factory;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;
using Xunit;

namespace QL_Tests
{
	public class ParseTests
	{
        private QLParser<ITypeCheckExpr, ITypeCheckStmnt, ITypeCheckType, QLTypeCheckFactory> parser;

		public ParseTests()
		{
            parser = new QLParser<ITypeCheckExpr, ITypeCheckStmnt, ITypeCheckType, QLTypeCheckFactory>(new QLTypeCheckFactory());

            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Core.Grammar.QL_Grammar.egt")));
		}

		[Fact]
		public void AddAssociation()
		{
			parser.OnCompletion += (root) =>
			{
				FormStmnt tree = new FormStmnt("Form1",
                    new LabelStmnt("\"Question 1:\"",
						new AddExpr(
							new AddExpr(
								new IntLiteral(5),
								new IntLiteral(2)
                            ),
							new IntLiteral(4)
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
					new LabelStmnt("\"Question 1:\"",
						new AddExpr(
							new IntLiteral(5),
							new MultiplyExpr(
								new IntLiteral(2),
								new IntLiteral(4)
							)
						)
					)
				);
				Assert.NotNull(root);
				Assert.Equal(root, tree);
			};

			bool parseOk = parser.Parse("form Form1 { \"Question 1:\" << 5 + 2 * 4; }");
			Assert.True(parseOk);
		}

        [Fact]
        public void CompStmntNestingRightHand()
        {
            parser.OnCompletion += (root) =>
            {
                FormStmnt tree = new FormStmnt("Form1",
                    new FormsStmnt(
                        new LabelStmnt("\"Question 1:\"",
                            new IntLiteral(5)
                        ),
                        new StatementsStmnt(
                            new LabelStmnt("\"Question 1:\"",
                                new IntLiteral(5)
                            ),
                            new StatementsStmnt(
                                new LabelStmnt("\"Question 1:\"",
                                    new IntLiteral(5)
                                ),
                                new LabelStmnt("\"Question 1:\"",
                                    new IntLiteral(5)
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
        //            new StatementsStmnt(
        //                new LabelStmnt("\"Question 1:\"",
        //                    new IntLiteral(5)
        //                ),
        //                new LabelStmnt("\"Question 1:\"",
        //                    new IntLiteral(5)
        //                ),
        //                new LabelStmnt("\"Question 1:\"",
        //                    new IntLiteral(5)
        //                ),
        //                new LabelStmnt("\"Question 1:\"",
        //                    new IntLiteral(5)
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
                        new BoolLiteral(true),
                        new IfElseStmnt(
                            new BoolLiteral(false),
                            new LabelStmnt("\"Question 1:\"",
                                new IntLiteral(7)
                            ),
                            new LabelStmnt("\"Question 2:\"",
                                new IntLiteral(13)
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
