using System;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Environment;
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

        public void TypeCheck(TypeEnvironment env)
        {
            Statement1.TypeCheck(env);
            Statement2.TypeCheck(env);
        }
    }
}
