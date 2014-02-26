using System.Collections.Generic;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public class FormStmnt : FormStmnt<ITypeCheckStmnt>, ITypeCheckStmnt
    {
		public FormStmnt(string name, ITypeCheckStmnt body)
            : base(name, body)
        {

        }

        public void TypeCheck(Queue<ITypeCheckStmnt> queue, TypeCheckData data)
        {
            data.Forms.Add(Name);

			queue.Enqueue(Body);
			if (queue.Count > 0) queue.Dequeue().TypeCheck(queue, data);

            data.Variables.Clear();
        }
    }
}
