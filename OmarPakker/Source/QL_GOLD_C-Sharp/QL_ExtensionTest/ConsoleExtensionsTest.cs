using System;
using System.IO;
using System.Reflection;
using System.Text;
using GOLD;
using Grammar.Parser;
using QL_ExtensionTest.Extensions.Check;
using QL_ExtensionTest.Extensions.Factory;
using QL_Grammar.Check;
using QL_Grammar.QLTypeCheck;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace QL_ExtensionTest
{
    public class ConsoleExtensionsTest
    {
        private readonly ExtensionsParser<ITypeCheckExpr, ITypeCheckStmnt, ExtensionsTypeCheckFactory> parser;

        public ConsoleExtensionsTest()
        {
            parser = new ExtensionsParser<ITypeCheckExpr, ITypeCheckStmnt, ExtensionsTypeCheckFactory>();
			parser.Factory = new ExtensionsTypeCheckFactory();

            parser.OnReduction += OnReduction;
            parser.OnCompletion += OnCompletion;
            parser.OnGroupError += OnGroupError;
            parser.OnInternalError += OnInternalError;
            parser.OnNotLoadedError += OnNotLoadedError;
            parser.OnLexicalError += OnLexicalError;
            parser.OnSyntaxError += OnSyntaxError;

            Assembly a = parser.Factory.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("QL_ExtensionTest.Grammar.QL_Grammar.egt")));
            parser.Parse(new StringBuilder().AppendLine("form Form1 {")
				.AppendLine("\"Power:\" << answer1:int = 5 ^ 2;")
				.AppendLine("\"Modulo:\" << 10 % 5;")
				.AppendLine("\"Modulo2:\" << 10 % true;")
				.AppendLine("loop(answer1)")
				.AppendLine("\"In the loop:\" >> loopAnswer:int;")
				.AppendLine("}").ToString());
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

            if (newObj is ITypeCheck)
            {
				((ITypeCheck)newObj).SourcePosition = parser.ParserPosition;
            }
        }

        private void OnCompletion(object root)
        {
			TypeChecker<CheckExtensionsExpressions, CheckExtensionsStmnts> tc
				= new TypeChecker<CheckExtensionsExpressions, CheckExtensionsStmnts>();

			if (tc.Check((ITypeCheck)root))
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
