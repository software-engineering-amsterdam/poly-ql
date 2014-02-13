using System.IO;
using System.Reflection;
using Grammar;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.Factory;
using QL_Grammar.QL.Expr;
using QL_Grammar.QL.Stmnt;
using QL_Grammar.QL.Value;
using Xunit;

namespace QL_Tests
{
	public class ParseTests
	{
		public ParseTests()
		{
			
		}

		private QLParser<IExprNode, IStmntNode> InitParser()
		{
			QLParser<IExprNode, IStmntNode> parser = new QLParser<IExprNode, IStmntNode>();
			parser.Factory = new QLFactory();
			Assembly a = typeof(QLParser<IExprNode, IStmntNode>).Assembly;
			parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("QL_Grammar.Grammar.QL_Grammar.egt")));
			return parser;
		}

		[Fact]
		public void AddAssociation()
		{
			QLParser<IExprNode, IStmntNode> parser = InitParser();

			parser.OnCompletion += (root) =>
			{
				FormStmnt tree = new FormStmnt("Form1",
					new QuestionStmnt("\"Question 1:\"", false,
						new AddExpr(
							new AddExpr(
								new LiteralExprNode(new IntValue(5)),
								new LiteralExprNode(new IntValue(2))),
							new LiteralExprNode(new IntValue(4))
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
			QLParser<IExprNode, IStmntNode> parser = InitParser();

			parser.OnCompletion += (root) =>
			{
				FormStmnt tree = new FormStmnt("Form1",
					new QuestionStmnt("\"Question 1:\"", false,
						new AddExpr(
							new LiteralExprNode(new IntValue(5)),
							new MultiplyExpr(
								new LiteralExprNode(new IntValue(2)),
								new LiteralExprNode(new IntValue(4))
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
			QLParser<IExprNode, IStmntNode> parser = InitParser();

			parser.OnCompletion += (root) =>
			{
				FormStmnt tree = new FormStmnt("Form1",
					new CompStmnt(
						new QuestionStmnt("\"Question 1:\"", false,
							new LiteralExprNode(new IntValue(5))
						),
						new QuestionStmnt("\"Question 1:\"", false,
							new LiteralExprNode(new IntValue(5))
						),
						new QuestionStmnt("\"Question 1:\"", false,
							new LiteralExprNode(new IntValue(5))
						),
						new QuestionStmnt("\"Question 1:\"", false,
							new LiteralExprNode(new IntValue(5))
						)
					)
				);
				Assert.NotNull(root);
				Assert.Equal(root, tree);
			};

			bool parseOk = parser.Parse("form Form1 { \"Question 1:\" << 5; \"Question 1:\" << 5; \"Question 1:\" << 5; \"Question 1:\" << 5; }");
			Assert.True(parseOk);
		}
	}
}
