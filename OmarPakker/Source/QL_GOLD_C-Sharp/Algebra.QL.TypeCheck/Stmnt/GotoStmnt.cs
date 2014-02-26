using System;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public class GotoStmnt : Algebra.QL.Core.Stmnt.GotoStmnt, ITypeCheckStmnt
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
