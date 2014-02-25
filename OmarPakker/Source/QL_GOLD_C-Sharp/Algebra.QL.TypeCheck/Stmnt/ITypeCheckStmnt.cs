using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Stmnt
{
	public interface ITypeCheckStmnt : ITypeCheck
	{
		void TypeCheck(TypeCheckData data);
	}
}
