using System;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public class GotoStmnt : Algebra.QL.Core.Stmnt.GotoStmnt, ITypeCheckStmnt
    {
        public Tuple<int, int> SourcePosition { get; set; }

        public GotoStmnt(string gotoName)
            : base(gotoName)
		{
            
		}

        public void TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            if (env.IsGotoDeclared(GotoName))
            {
                errRep.ReportWarning(String.Format("You already defined a goto for Form {0}. Are you sure you want to go to the same form?",
                    GotoName), SourcePosition);
            }

            if (!env.IsFormDeclared(GotoName))
            {
                errRep.ReportError(String.Format("'goto' statement not possible. Form '{0}' does not exist!",
                    GotoName), SourcePosition);
            }

            env.DeclareGoto(GotoName);
        }
    }
}
