using QL_Grammar.Algebra.Type;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public interface ITypeCheckExpr : ITypeCheck
	{
		IType TypeCheck(TypeCheckData data);
	}
}
