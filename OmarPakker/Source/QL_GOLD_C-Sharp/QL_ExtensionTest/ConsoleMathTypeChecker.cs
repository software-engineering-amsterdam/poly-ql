using System;
using System.IO;
using System.Reflection;
using GOLD;
using Grammar.Parser;
using QL_ExtensionTest.Mathematics;
using QL_ExtensionTest.Mathematics.Factory;
using QL_Grammar.AST;
using QL_Grammar.Check;

namespace QL_ExtensionTest
{
    public class ConsoleMathTypeChecker
    {
        private readonly MathParser parser;
        private readonly MathFactory factory;

        public ConsoleMathTypeChecker()
        {
            parser = new MathParser();
            parser.Factory = factory = new MathFactory();

            parser.OnReduction += OnReduction;
            parser.OnCompletion += OnCompletion;
            parser.OnGroupError += OnGroupError;
            parser.OnInternalError += OnInternalError;
            parser.OnNotLoadedError += OnNotLoadedError;
            parser.OnLexicalError += OnLexicalError;
            parser.OnSyntaxError += OnSyntaxError;

            Assembly a = typeof(ConsoleMathTypeChecker).Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("QL_ExtensionTest.Grammar.QL_Grammar.egt")));
            parser.Parse("form Form1 { \"Power:\" << answer1:int = 5 ^ 2; \"Modulo:\" << 10 % 5; \"Modulo2:\" << 10 % true; }");
        }

        private void OnReduction(Reduction r, object newObj)
        {
            int count = r.Count();
            string dataOutput = String.Empty;

            for (int i = 0; i < count; i++)
            {
                dataOutput += r.get_Data(i).ToString();
            }

            Console.WriteLine(String.Format("R: {0}, C: {1}, D: {2}", r.Parent.Text(), count, dataOutput));

            if (newObj is IASTNode)
            {
				((IASTNode)newObj).SourcePosition = parser.ParserPosition;
            }
        }

        private void OnCompletion(object root)
        {
			TypeChecker<CheckMathExpressions, CheckStatements<CheckMathExpressions>> tc
				= new TypeChecker<CheckMathExpressions, CheckStatements<CheckMathExpressions>>();

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
