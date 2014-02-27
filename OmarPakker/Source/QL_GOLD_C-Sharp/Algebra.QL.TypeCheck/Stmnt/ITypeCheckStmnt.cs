using System.Collections.Generic;
using Algebra.Core.Tree;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public interface ITypeCheckStmnt : ITypeCheck, IStmntNode
	{
		void TypeCheck(Queue<ITypeCheckStmnt> queue, TypeCheckData data);
	}
}
