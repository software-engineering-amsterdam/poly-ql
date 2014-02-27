using System.Collections.Generic;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public class StatementsStmnt : CompStmnt<ITypeCheckStmnt>, ITypeCheckStmnt
    {
        public StatementsStmnt(ITypeCheckStmnt a, ITypeCheckStmnt b)
            : base(a, b)
        {

        }

        public void TypeCheck(Queue<ITypeCheckStmnt> queue, TypeCheckData data)
        {
            Statement1.TypeCheck(queue, data);
            Statement2.TypeCheck(queue, data);
        }
    }
}
