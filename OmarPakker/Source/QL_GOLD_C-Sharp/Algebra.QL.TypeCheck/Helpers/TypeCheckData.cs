using System;
using System.Collections.Generic;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Stmnt;

namespace Algebra.QL.TypeCheck.Helpers
{
    public class TypeCheckData
    {
		public delegate void OnTypeCheckErrorEventHandler(string msg, bool error);
		public event OnTypeCheckErrorEventHandler OnTypeCheckError;

        public HashSet<string> Forms { get; private set; }
        public List<string> Gotos { get; private set; }
        public Dictionary<string, VarInitExpr> Variables { get; private set; }

        public TypeCheckData()
        {
            Forms = new HashSet<string>();
            Gotos = new List<string>();
            Variables = new Dictionary<string, VarInitExpr>();
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
