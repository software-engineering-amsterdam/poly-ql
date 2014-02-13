using System;
using System.IO;
using System.Reflection;
using GOLD;
using Grammar;
using QL_Grammar.AST;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.Check;
using QL_Grammar.Factory;

namespace ConsoleParser
{
    public class ConsoleTypeChecker
	{
        private readonly QLParser<IExprNode, IStmntNode, QLFactory> parser;

        public ConsoleTypeChecker()
            : base()
        {
            parser = new QLParser<IExprNode, IStmntNode, QLFactory>();
            parser.Factory = new QLFactory();

            parser.OnReduction += OnReduction;
            parser.OnCompletion += OnCompletion;
            parser.OnGroupError += OnGroupError;
            parser.OnInternalError += OnInternalError;
            parser.OnNotLoadedError += OnNotLoadedError;
            parser.OnLexicalError += OnLexicalError;
            parser.OnSyntaxError += OnSyntaxError;

            Assembly a = parser.Factory.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("QL_Grammar.Grammar.QL_Grammar.egt")));
            parser.Parse(System.IO.File.OpenText(@"..\..\..\..\..\Grammar\QL_Test.txt"));
        }

        private void OnReduction(Reduction r, object newObj)
        {
            int count = r.Count();
            string dataOutput = String.Empty;

			for (int i = 0; i < count; i++)
			{
				object data = r.get_Data(i);
				if (data != null)
				{
					dataOutput += data.ToString();
				}
			}

            Console.WriteLine(String.Format("R: {0}, C: {1}, D: {2}", r.Parent.Text(), count, dataOutput));

			if (newObj is IASTNode)
			{
				((IASTNode)newObj).SourcePosition = parser.ParserPosition;
			}
        }

        private void OnCompletion(object root)
        {
			TypeChecker<CheckExpressions, CheckStatements<CheckExpressions>> tc
				= new TypeChecker<CheckExpressions, CheckStatements<CheckExpressions>>();

			if (tc.Check((IASTNode)root))
			{
				foreach (Tuple<string, bool> msg in tc.Errors)
				{
					Console.ForegroundColor = msg.Item2 ? ConsoleColor.Red : ConsoleColor.Yellow;
					Console.WriteLine(msg.Item1);
				}

				Console.ResetColor();
			}

            Console.WriteLine("PARSING COMPLETED!");
        }

		private void OnGroupError()
		{
			Console.WriteLine("ERROR: Unexpected EOF. (Group Error)");
		}

        private void OnInternalError()
		{
			Console.WriteLine("ERROR: INTERNAL ERROR");
		}

        private void OnNotLoadedError()
		{
			Console.WriteLine("ERROR: Grammar file was not loaded");
		}

        private void OnLexicalError(int line, int column, object token)
		{
			Console.WriteLine(String.Format("ERROR: Unknown token '{0}' found on line {1} column {2}", token, line, column));
		}

        private void OnSyntaxError(int line, int column, object token, string expected)
		{
			Console.WriteLine(String.Format("ERROR: Unexpected token '{0}' on line {1} column {2}. Expected: {3}",
				token, line, column, expected));
		}
	}
}
