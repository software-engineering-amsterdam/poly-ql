using System;
using System.IO;
using System.Reflection;
using System.Text;
using GOLD;
using Grammar.Parser;
using QL_ExtensionTest.Merged;
using QL_ExtensionTest.QLEval.Expr;
using QL_ExtensionTest.QLEval.Stmnt;
using QL_Grammar.QLTypeCheck;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Helpers;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace QL_ExtensionTest
{
    public class ConsoleExtensionsTest
    {
        public ConsoleExtensionsTest()
        {
            //var parser = new ExtensionsParser<ITypeCheckExpr, ITypeCheckStmnt, QLTypeCheckExtensionsFactory>();
			//parser.Factory = new QLTypeCheckExtensionsFactory();
            var parser = new ExtensionsParser<Tuple<ITypeCheckExpr, IEvalExpr>, Tuple<ITypeCheckStmnt, IEvalStmnt>, TypeCheckEvalFactory>();
            parser.Factory = new TypeCheckEvalFactory();

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
				.AppendLine("\"Date Type:\" >> dateVar:date;")
				.AppendLine("\"Date:\" << 2014-02-20T16:22:00+01:00;")
				.AppendLine("loop(answer1)")
				.AppendLine("\"In the loop:\" >> loopAnswer:int;")
				.AppendLine("}").ToString());
        }

        private void OnReduction(int line, int column, Reduction r, object newObj)
        {
            int count = r.Count();
            string dataOutput = String.Empty;

            for (int i = 0; i < count; i++)
            {
				object data = r.get_Data(i);
				if (data != null)
				{
					dataOutput += data;
				}
            }

            Console.WriteLine(String.Format("R: {0}, C: {1}, D: {2}", r.Parent.Text(), count, dataOutput));

			if (newObj is ITypeCheck)
			{
				((ITypeCheck)newObj).SourcePosition = new Tuple<int, int>(line, column);
			}
        }

        private void OnCompletion(object root)
        {
			TypeCheckData data = new TypeCheckData();
			data.OnTypeCheckError += (msg, error) =>
			{
				Console.ForegroundColor = error ? ConsoleColor.Red : ConsoleColor.Yellow;
				Console.WriteLine(msg);
				Console.ResetColor();
			};

			((Tuple<ITypeCheckStmnt, IEvalStmnt>)root).Item1.TypeCheck(data);
			data.VerifyTopDownDependencies();

            Console.WriteLine("PARSING COMPLETED!");
        }

		private void OnGroupError()
		{
			Console.ForegroundColor = ConsoleColor.Red;
			Console.WriteLine("ERROR: Unexpected EOF. (Group Error)");
			Console.ResetColor();
		}

        private void OnInternalError()
		{
			Console.ForegroundColor = ConsoleColor.Red;
			Console.WriteLine("ERROR: INTERNAL ERROR");
			Console.ResetColor();
		}

        private void OnNotLoadedError()
		{
			Console.ForegroundColor = ConsoleColor.Red;
			Console.WriteLine("ERROR: Grammar file was not loaded");
			Console.ResetColor();
		}

        private void OnLexicalError(int line, int column, object token)
		{
			Console.ForegroundColor = ConsoleColor.Red;
			Console.WriteLine(String.Format("ERROR: Unknown token '{0}' found on line {1} column {2}", token, line, column));
			Console.ResetColor();
		}

        private void OnSyntaxError(int line, int column, object token, string expected)
		{
			Console.ForegroundColor = ConsoleColor.Red;
			Console.WriteLine(String.Format("ERROR: Unexpected token '{0}' on line {1} column {2}. Expected: {3}",
				token, line, column, expected));
			Console.ResetColor();
		}
    }
}
