using System;
using System.IO;
using System.Reflection;
using GOLD;
using Grammar.Parser;
using QL_ExtensionTest.Extensions.Check;
using QL_ExtensionTest.Extensions.Factory;
using QL_Grammar.AST;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.Check;

namespace QL_ExtensionTest
{
    public class ConsoleExtensionsTest
    {
        private readonly ExtensionsParser<IExprNode, IStmntNode, ExtensionsFactory> parser;

        public ConsoleExtensionsTest()
        {
            parser = new ExtensionsParser<IExprNode, IStmntNode, ExtensionsFactory>();
			parser.Factory = new ExtensionsFactory();

            parser.OnReduction += OnReduction;
            parser.OnCompletion += OnCompletion;
            parser.OnGroupError += OnGroupError;
            parser.OnInternalError += OnInternalError;
            parser.OnNotLoadedError += OnNotLoadedError;
            parser.OnLexicalError += OnLexicalError;
            parser.OnSyntaxError += OnSyntaxError;

            Assembly a = parser.Factory.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("QL_ExtensionTest.Grammar.QL_Grammar.egt")));
            parser.Parse("form Form1 { \"Power:\" << answer1:int = 5 ^ 2; \"Modulo:\" << 10 % 5; \"Modulo2:\" << 10 % true; }");
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
			TypeChecker<CheckExtensionsExpressions, CheckExtensionsStmnts> tc
				= new TypeChecker<CheckExtensionsExpressions, CheckExtensionsStmnts>();

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
