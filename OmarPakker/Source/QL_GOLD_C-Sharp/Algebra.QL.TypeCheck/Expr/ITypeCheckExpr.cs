using Algebra.Core.Type;
using Algebra.QL.TypeCheck.Helpers;

namespace Algebra.QL.TypeCheck.Expr
{
	public interface ITypeCheckExpr : ITypeCheck
	{
		IType TypeCheck(TypeCheckData data);
	}
}
