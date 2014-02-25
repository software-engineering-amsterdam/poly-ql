using System.Collections.Generic;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public interface ITypeCheckStmnt : ITypeCheck
	{
		void TypeCheck(Queue<ITypeCheckStmnt> queue, TypeCheckData data);
	}
}
