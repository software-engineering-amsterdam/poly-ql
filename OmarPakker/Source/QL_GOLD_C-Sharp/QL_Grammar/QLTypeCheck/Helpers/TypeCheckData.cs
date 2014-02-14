using System;
using System.Collections.Generic;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace QL_Grammar.QLTypeCheck.Helpers
{
    public class TypeCheckData
    {
        public HashSet<string> Forms { get; private set; }
        public List<GotoStmnt> Gotos { get; private set; }
        public Dictionary<string, VarInitExpr> Variables { get; private set; }
        public List<Tuple<string, bool>> Errors { get; private set; }
        public bool HasErrors { get { return Errors.Count > 0; } }

        public TypeCheckData()
        {
            Forms = new HashSet<string>();
            Gotos = new List<GotoStmnt>();
            Variables = new Dictionary<string, VarInitExpr>();
            Errors = new List<Tuple<string, bool>>();
        }

        public void VerifyForms()
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
            string finalMsg = ConstructMessage("ERROR! " + msg, pos);
            
            Errors.Add(new Tuple<string, bool>(finalMsg, true));
        }

        public void ReportWarning(string msg, Tuple<int, int> pos)
        {
            string finalMsg = ConstructMessage("WARNING! " + msg, pos);

            Errors.Add(new Tuple<string, bool>(finalMsg, false));
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
