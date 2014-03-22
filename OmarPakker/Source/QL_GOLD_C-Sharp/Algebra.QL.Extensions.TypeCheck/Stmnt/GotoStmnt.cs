using System;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Stmnt;

namespace Algebra.QL.Extensions.TypeCheck.Stmnt
{
	public class GotoStmnt : ITypeCheckStmnt
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public GotoStmnt()
		{
            
		}

        public void TypeCheck(TypeEnvironment env)
        {
            //if (env.IsGotoDeclared())
            //{
            //    errRep.ReportError(this, "You already defined a gotoNextForm. You can only have 1 per form.");

            //    return;
            //}

            //env.DeclareGoto();
        }
    }
}
