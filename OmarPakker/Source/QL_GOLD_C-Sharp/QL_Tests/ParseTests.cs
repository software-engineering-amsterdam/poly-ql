using System.IO;
using System.Reflection;
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
		public ParseTests()
		{
			
		}

		private QLParser<ITypeCheckExpr, ITypeCheckStmnt, QLTypeCheckFactory> InitParser()
		{
			QLParser<ITypeCheckExpr, ITypeCheckStmnt, QLTypeCheckFactory> parser = new QLParser<ITypeCheckExpr, ITypeCheckStmnt, QLTypeCheckFactory>();
			parser.Factory = new QLTypeCheckFactory();
			Assembly a = parser.Factory.GetType().Assembly;
			parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("QL_Grammar.Grammar.QL_Grammar.egt")));
			return parser;
		}

		[Fact]
		public void AddAssociation()
		{
			QLParser<ITypeCheckExpr, ITypeCheckStmnt, QLTypeCheckFactory> parser = InitParser();

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
			QLParser<ITypeCheckExpr, ITypeCheckStmnt, QLTypeCheckFactory> parser = InitParser();

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
			QLParser<ITypeCheckExpr, ITypeCheckStmnt, QLTypeCheckFactory> parser = InitParser();

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

			bool parseOk = parser.Parse("form Form1 { \"Question 1:\" << 5; \"Question 1:\" << 5; \"Question 1:\" << 5; \"Question 1:\" << 5; }");
			Assert.True(parseOk);
		}
	}
}
