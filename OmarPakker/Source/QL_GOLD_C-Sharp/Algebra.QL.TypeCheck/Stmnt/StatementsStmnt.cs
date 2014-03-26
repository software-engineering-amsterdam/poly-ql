using System;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Environment;

namespace Algebra.QL.TypeCheck.Stmnt
{
    public class StatementsStmnt : CompStmnt<ITypeCheckStmnt>, ITypeCheckStmnt
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }

        public StatementsStmnt(ITypeCheckStmnt a, ITypeCheckStmnt b)
            : base(a, b)
        {

        }

        public void TypeCheck(TypeEnvironment env)
        {
            Statement1.TypeCheck(env);
            Statement2.TypeCheck(env);
        }
    }
}
