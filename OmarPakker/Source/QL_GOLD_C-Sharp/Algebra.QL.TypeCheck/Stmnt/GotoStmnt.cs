using System;
using System.Collections.Generic;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public class GotoStmnt : Algebra.QL.Core.Stmnt.GotoStmnt, ITypeCheckStmnt
    {
        public GotoStmnt(string gotoName)
            : base(gotoName)
		{
            
		}

        public void TypeCheck(Queue<ITypeCheckStmnt> queue, TypeCheckData data)
        {
            if (data.Gotos.Contains(GotoName))
            {
                data.ReportWarning(String.Format("You already defined a goto for Form {0}. Are you sure you want to go to the same form?",
                    GotoName), SourcePosition);
            }

            if (!data.Forms.Contains(GotoName))
            {
                data.ReportError(String.Format("'goto' statement not possible. Form '{0}' does not exist!",
                    GotoName), SourcePosition);
            }

            data.Gotos.Add(GotoName);
        }
    }
}
