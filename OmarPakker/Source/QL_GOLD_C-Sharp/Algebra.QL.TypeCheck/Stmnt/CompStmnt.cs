using System.Collections.Generic;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public class CompStmnt : CompStmnt<ITypeCheckStmnt>, ITypeCheckStmnt
    {
		public CompStmnt(ITypeCheckStmnt a, ITypeCheckStmnt b)
            : base(a, b)
        {

        }

        public void TypeCheck(Queue<ITypeCheckStmnt> queue, TypeCheckData data)
        {
            queue.Enqueue(Statement1);
            queue.Enqueue(Statement2);
            if (queue.Count > 0) queue.Dequeue().TypeCheck(queue, data);
        }
    }
}
