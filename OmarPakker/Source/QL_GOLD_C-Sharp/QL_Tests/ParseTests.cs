using System.IO;
using System.Reflection;
using System.Text;
using Grammar;
using QL_Grammar.QLAlgebra.Value;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Factory;
using QL_Grammar.QLTypeCheck.Stmnt;
using Xunit;

namespace QL_Tests
{
	public class ParseTests
	{
        private QLParser<ITypeCheckExpr, ITypeCheckStmnt, QLTypeCheckFactory> parser;

		public ParseTests()
		{
            parser = new QLParser<ITypeCheckExpr, ITypeCheckStmnt, QLTypeCheckFactory>();
            parser.Factory = new QLTypeCheckFactory();
            Assembly a = parser.Factory.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("QL_Grammar.Grammar.QL_Grammar.egt")));
		}

		[Fact]
		public void AddAssociation()
		{
			parser.OnCompletion += (root) =>
			{
				FormStmnt tree = new FormStmnt("Form1",
					new QuestionStmnt("\"Question 1:\"", false,
						new AddExpr(
							new AddExpr(
								new LiteralExpr(new IntValue(5)),
								new LiteralExpr(new IntValue(2))),
							new LiteralExpr(new IntValue(4))
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
					new QuestionStmnt("\"Question 1:\"", false,
						new AddExpr(
							new LiteralExpr(new IntValue(5)),
							new MultiplyExpr(
								new LiteralExpr(new IntValue(2)),
								new LiteralExpr(new IntValue(4))
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
		public void CompStmntFlattened()
		{
			parser.OnCompletion += (root) =>
			{
				FormStmnt tree = new FormStmnt("Form1",
					new CompStmnt(
						new QuestionStmnt("\"Question 1:\"", false,
							new LiteralExpr(new IntValue(5))
						),
						new QuestionStmnt("\"Question 1:\"", false,
							new LiteralExpr(new IntValue(5))
						),
						new QuestionStmnt("\"Question 1:\"", false,
							new LiteralExpr(new IntValue(5))
						),
						new QuestionStmnt("\"Question 1:\"", false,
							new LiteralExpr(new IntValue(5))
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

        [Fact]
        public void AssociatesElseCorrectly()
        {
            parser.OnCompletion += (root) =>
            {
                FormStmnt tree = new FormStmnt("Form1",
                    new IfStmnt(
                        new LiteralExpr(new BoolValue(true)),
                        new IfElseStmnt(
                            new LiteralExpr(new BoolValue(false)),
                            new QuestionStmnt("\"Question 1:\"", false,
                                new LiteralExpr(new IntValue(7))
                            ),
                            new QuestionStmnt("\"Question 2:\"", false,
                                new LiteralExpr(new IntValue(13))
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
