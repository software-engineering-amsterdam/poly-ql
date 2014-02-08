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

        public ConsoleTypeCheckParser()
            : base(new TypeCheckFactory())
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

        protected override void OnObjectCreated(ITypeCheckExpr exprObj)
        {
            string msg;
            bool error = exprObj.CheckTypesValid(out msg);
            if (!String.IsNullOrEmpty(msg))
            {
                Position pPos = ParserPosition;
                msgs.Add(String.Format("Invalid expression on line {0} column {1}. ", pPos.Line, pPos.Column) + msg, error);
            }
        }

        protected override void OnObjectCreated(ITypeCheckStmnt stmntObj)
        {
            string msg;
            bool error = stmntObj.CheckTypesValid(out msg);
            if (!String.IsNullOrEmpty(msg))
            {
                Position pPos = ParserPosition;
                msgs.Add(String.Format("Invalid statement on line {0} column {1}. ", pPos.Line, pPos.Column) + msg, error);
            }
        }

        protected override void OnCompletion(object root)
        {
            ITypeCheckStmnt evalRoot = (ITypeCheckStmnt)root;

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
