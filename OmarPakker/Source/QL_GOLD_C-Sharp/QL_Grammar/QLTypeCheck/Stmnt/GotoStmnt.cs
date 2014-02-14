using System;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Stmnt
{
	public class GotoStmnt : QL_Grammar.QLAlgebra.Stmnt.GotoStmnt, ITypeCheckStmnt
    {
        public GotoStmnt(string gotoName)
            : base(gotoName)
		{
            
		}

        public void TypeCheck(TypeCheckData data)
        {
            if (data.Gotos.Exists((item) => item.GotoName.Equals(GotoName)))
            {
                data.ReportWarning(String.Format("You already defined a goto for Form {0}. Are you sure you want to go to the same form?",
                    GotoName), SourcePosition);
            }

            data.Gotos.Add(this);
        }
    }
}
