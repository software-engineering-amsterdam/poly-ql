using System;
using System.Collections.Generic;
using System.IO;
using System.Reflection;
using GOLD;
using Grammar;
using QL_Grammar.Factory;
using QL_Grammar.TypeCheck.Expr;
using QL_Grammar.TypeCheck.Stmnt;

namespace QL_GOLD_C_Sharp
{
    public class ConsoleTypeChecker
	{
        private readonly QLParser<ITypeCheckExpr, ITypeCheckStmnt> parser;
        private readonly TypeCheckFactory factory;
        private readonly Dictionary<string, bool> msgs;

        public ConsoleTypeChecker()
            : base()
        {
            parser = new QLParser<ITypeCheckExpr, ITypeCheckStmnt>();
            parser.Factory = factory = new TypeCheckFactory();
            msgs = new Dictionary<string, bool>();

            parser.OnReduction += OnReduction;
            parser.OnCompletion += OnCompletion;
            parser.OnGroupError += OnGroupError;
            parser.OnInternalError += OnInternalError;
            parser.OnNotLoadedError += OnNotLoadedError;
            parser.OnLexicalError += OnLexicalError;
            parser.OnSyntaxError += OnSyntaxError;

            Assembly a = typeof(QLParser<ITypeCheckExpr, ITypeCheckStmnt>).Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("QL_Grammar.Grammar.QL_Grammar.egt")));
            parser.Parse(System.IO.File.OpenText(@"..\..\..\..\..\Grammar\QL_Test.txt"));
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

            //Factory handles variable expressions for us. Check for those errors now.
            if (factory.HasErrors)
            {
                Position pPos = parser.ParserPosition;
                foreach (var error in factory.ErrorMsgs)
                {
                    CreateErrorMsgEntry(new Tuple<string, bool, int, int>(error.Item1, error.Item2, pPos.Line, pPos.Column));
                }
                factory.ErrorMsgs.Clear();
            }

            //Expressions can be verified during parsing! :D
            if (newObj is ITypeCheckExpr)
            {
                CreateErrorMsgEntries((ITypeCheckExpr)newObj);
            }
            //Statements are evaluated afterwards so we need to store their position
            //to be able to supply useful information to locate the error.
            else if (newObj is ITypeCheckStmnt)
            {
                ((ITypeCheckStmnt)newObj).StatementSourcePosition = new Tuple<int, int>(
                    parser.ParserPosition.Line, parser.ParserPosition.Column);
            }
        }

        private void CreateErrorMsgEntries(ITypeCheckExpr expr)
        {
            var errors = expr.CheckTypesValid();

            if(errors == null)
            {
                return;
            }

            Position pPos = parser.ParserPosition;
            foreach(var error in errors)
            {
                CreateErrorMsgEntry(new Tuple<string, bool, int, int>(error.Item1, error.Item2, pPos.Line, pPos.Column));
            }
        }

        private void CreateErrorMsgEntries(ITypeCheckStmnt stmnt)
        {
            CreateErrorMsgEntries(stmnt.CheckTypesValid());
        }

        private void CreateErrorMsgEntries(IEnumerable<Tuple<string, bool, int, int>> errors)
        {
            foreach (var error in errors)
            {
                CreateErrorMsgEntry(error);
            }
        }

        private void CreateErrorMsgEntry(Tuple<string, bool, int, int> error)
        {
            if (error == null)
            {
                return;
            }

            msgs.Add(String.Format("{0} on line {1} column {2}. {3}", error.Item2 ? "ERROR" : "WARNING",
                //Line property starts on 0 so offset it to correct that.
                //Column will point to the end of the statement.
                error.Item3 + 1, error.Item4, error.Item1), error.Item2);
        }

        private void OnCompletion(object root)
        {
            CreateErrorMsgEntries(((ITypeCheckStmnt)root).CheckTypesValid());

            foreach(KeyValuePair<string, bool> msg in msgs)
            {
                Console.ForegroundColor = msg.Value ? ConsoleColor.Red : ConsoleColor.Yellow;
                Console.WriteLine(msg.Key);
            }

            Console.ResetColor();
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
