using System;
using System.Collections.Generic;
using com.OPCreations.GoldParser;
using GOLD;
using QL_Grammar;
using QL_Grammar.Factory;
using QL_Grammar.TypeCheck.Expr;
using QL_Grammar.TypeCheck.Stmnt;

namespace QL_GOLD_C_Sharp
{
    public class ConsoleTypeCheckParser : QLParser<ITypeCheckExpr, ITypeCheckStmnt>
	{
        private readonly Dictionary<string, bool> msgs;
        private readonly TypeCheckFactory factory = new TypeCheckFactory();
        protected override IFactory<ITypeCheckExpr, ITypeCheckStmnt> Factory { get { return factory; } }

        public ConsoleTypeCheckParser()
            : base()
        {
            msgs = new Dictionary<string, bool>();
        }

        protected override object OnReduction(Reduction r)
        {
            RuleIndex rIndex = (RuleIndex)r.Parent.TableIndex();
            int count = r.Count();
            string dataOutput = String.Empty;

            for (int i = 0; i < count; i++)
            {
                dataOutput += r.get_Data(i).ToString();
            }

            Console.WriteLine(String.Format("R: {0}, C: {1}, D: {2}", rIndex, count, dataOutput));

            return base.OnReduction(r);
        }

        protected override void OnObjectCreated(object obj)
        {
            //Factory handles variable expressions for us. Check for those errors now.
            if (factory.HasErrors)
            {
                Position pPos = ParserPosition;
                foreach (var error in factory.ErrorMsgs)
                {
                    CreateErrorMsgEntry(new Tuple<string, bool, int, int>(error.Item1, error.Item2, pPos.Line, pPos.Column));
                }
                factory.ErrorMsgs.Clear();
            }

            //Expressions can be verified during parsing! :D
            if(obj is ITypeCheckExpr)
            {
                CreateErrorMsgEntries((ITypeCheckExpr)obj);
            }
            //Statements are evaluated afterwards so we need to store their position
            //to be able to supply useful information to locate the error.
            else if(obj is ITypeCheckStmnt)
            {
                ((ITypeCheckStmnt)obj).StatementSourcePosition = new Tuple<int, int>(ParserPosition.Line, ParserPosition.Column);
            }
        }

        private void CreateErrorMsgEntries(ITypeCheckExpr expr)
        {
            var errors = expr.CheckTypesValid();

            if(errors == null)
            {
                return;
            }

            Position pPos = ParserPosition;
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

        protected override void OnCompletion(object root)
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

		protected override void OnGroupError()
		{
			Console.WriteLine("ERROR: Unexpected EOF. (Group Error)");
		}

		protected override void OnInternalError()
		{
			Console.WriteLine("ERROR: INTERNAL ERROR");
		}

		protected override void OnNotLoadedError()
		{
			Console.WriteLine("ERROR: Grammar file was not loaded");
		}

		protected override void OnLexicalError(int line, int column, object token)
		{
			Console.WriteLine(String.Format("ERROR: Unknown token '{0}' found on line {1} column {2}", token, line, column));
		}

		protected override void OnSyntaxError(int line, int column, object token, string expected)
		{
			Console.WriteLine(String.Format("ERROR: Unexpected token '{0}' on line {1} column {2}. Expected: {3}",
				token, line, column, expected));
		}
	}
}
