using System;
using System.Collections.Generic;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Stmnt;

namespace Algebra.QL.Extensions.TypeCheck.Stmnt
{
    public class FormsStmnt : CompStmnt<ITypeCheckStmnt>, ITypeCheckStmnt
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public FormsStmnt(ITypeCheckStmnt a, ITypeCheckStmnt b)
            : base(a, b)
        {

        }

        public void TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            Statement1.TypeCheck(env, errRep);
            Statement2.TypeCheck(env, errRep);

            foreach (KeyValuePair<string, ITypeCheck> gotoStmnt in env.GetGotosWithoutForm())
            {
                errRep.ReportError(gotoStmnt.Value, String.Format("'goto' statement not possible. Form '{0}' does not exist!",
                    gotoStmnt.Key));
            }
        }
    }
}
