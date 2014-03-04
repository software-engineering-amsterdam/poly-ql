using System;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public class CompStmnt : CompStmnt<ITypeCheckStmnt>, ITypeCheckStmnt
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public CompStmnt(ITypeCheckStmnt a, ITypeCheckStmnt b)
            : base(a, b)
        {

        }

        public void TypeCheck(TypeEnvironment env, ErrorReporter errRep)
        {
            Statement1.TypeCheck(env, errRep);
            Statement2.TypeCheck(env, errRep);
        }
    }
}
