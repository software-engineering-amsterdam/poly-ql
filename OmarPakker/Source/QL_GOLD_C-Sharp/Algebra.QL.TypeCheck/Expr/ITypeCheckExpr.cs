using Algebra.Core.Tree;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
    public interface ITypeCheckExpr : ITypeCheck, IExprNode
	{
        ITypeCheckType TypeCheck(TypeCheckData data);
	}
}
