using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.TypeCheck.Stmnt
{
    public class GotoStmnt : GotoStmntNode, ITypeCheckStmnt
    {
        public ReadOnlyDictionary<string, ITypeCheckStmnt> Forms { get; private set; }

        public GotoStmnt(string gotoName, Dictionary<string, ITypeCheckStmnt> forms)
            : base(gotoName)
		{
            Forms = new ReadOnlyDictionary<string, ITypeCheckStmnt>(forms);
		}

        public bool CheckTypesValid(out string msg)
        {
            if (!Forms.ContainsKey(GotoName))
            {
                //TODO: Fix 'goto' statement. Always has an error now since the form is only parsed later.
                //Revamp type checking to execute afterwards recursively instead of during parsing? All forms are known at the end.
                msg = String.Format("'goto' not possible. Form '{0}' does not exist!", GotoName);
                return true;
            }

            msg = null;
            return false;
        }
    }
}
