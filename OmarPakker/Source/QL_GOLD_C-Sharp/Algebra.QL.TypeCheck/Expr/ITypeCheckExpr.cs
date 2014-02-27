using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
    public interface ITypeCheckExpr : ITypeCheck
	{
        ITypeCheckType TypeCheck(TypeEnvironment env, ErrorReporter errRep);
	}
}
