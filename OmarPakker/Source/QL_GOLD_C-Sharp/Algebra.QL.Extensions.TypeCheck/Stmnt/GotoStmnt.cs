using System;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Stmnt;

namespace Algebra.QL.Extensions.TypeCheck.Stmnt
{
	public class GotoStmnt : Algebra.QL.Extensions.Stmnt.GotoStmnt, ITypeCheckStmnt
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public GotoStmnt(string gotoName)
            : base(gotoName)
		{
            
		}

        public void TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            //TODO: Implement Form/Goto jumping
            //if (env.IsGotoDeclared(GotoName))
            //{
            //    errRep.ReportWarning(this, String.Format("You already defined a goto for Form {0}. Are you sure you want to go to the same form?",
            //        GotoName));
            //}

            //if (!env.IsFormDeclared(GotoName))
            //{
            //    errRep.ReportError(this, String.Format("'goto' statement not possible. Form '{0}' does not exist!",
            //        GotoName));
            //}

            //env.DeclareGoto(GotoName);
        }
    }
}
