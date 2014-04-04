using System;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Stmnt;

namespace Algebra.QL.Extensions.TypeCheck.Stmnt
{
    public class GotoStmnt : ITypeCheckStmnt
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        private const string gotoDeclareName = "$GOTO$";

        public GotoStmnt()
        {
            
        }

        public void TypeCheck(ITypeEnvironment env)
        {
            if (env.IsDeclared(gotoDeclareName))
            {
                env.ReportError("You already defined a gotoNextForm. You can only have 1 per form.",
                    SourceStartPosition, SourceEndPosition);

                return;
            }

            env.Declare(gotoDeclareName, null);
        }
    }
}
