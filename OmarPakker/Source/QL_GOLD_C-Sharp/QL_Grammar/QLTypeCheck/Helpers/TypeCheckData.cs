using System;
using System.Collections.Generic;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace QL_Grammar.QLTypeCheck.Helpers
{
    public class TypeCheckData
    {
		public delegate void OnTypeCheckErrorEventHandler(string msg, bool error);
		public event OnTypeCheckErrorEventHandler OnTypeCheckError;

        public HashSet<string> Forms { get; private set; }
        public List<GotoStmnt> Gotos { get; private set; }
        public Dictionary<string, VarInitExpr> Variables { get; private set; }

        public TypeCheckData()
        {
            Forms = new HashSet<string>();
            Gotos = new List<GotoStmnt>();
            Variables = new Dictionary<string, VarInitExpr>();
        }

		//TODO: Do a Breadth-First traversal instead? No need to check stuff afterwards (statements like 'goto' create this problem)
		public void VerifyTopDownDependencies()
		{
			Gotos.RemoveAll((item) => Forms.Contains(item.GotoName));

			foreach (GotoStmnt item in Gotos)
			{
				ReportError(String.Format("'goto' statement not possible. Form '{0}' does not exist!",
					item.GotoName), item.SourcePosition);
			}
		}

        public void ReportError(string msg, Tuple<int, int> pos)
        {
			if (OnTypeCheckError != null)
			{
				OnTypeCheckError(ConstructMessage("ERROR! " + msg, pos), true);
			}
        }

        public void ReportWarning(string msg, Tuple<int, int> pos)
        {
			if (OnTypeCheckError != null)
			{
				OnTypeCheckError(ConstructMessage("WARNING! " + msg, pos), false);
			}
        }

        private string ConstructMessage(string msg, Tuple<int, int> pos)
        {
            if (pos != null)
            {
                msg += String.Format(" (line {0} column {1}).",
                    //Line/column properties start on 0 so offset it to correct that.
                    //Column points to the character index at the end of the statement.
                    pos.Item1 + 1, pos.Item2 + 1);
            }
            return msg;
        }
    }
}
