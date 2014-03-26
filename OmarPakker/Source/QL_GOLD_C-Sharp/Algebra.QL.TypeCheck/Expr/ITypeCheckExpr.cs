using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Expr
{
    public interface ITypeCheckExpr : ITypeCheck
    {
        ITypeCheckType TypeCheck(TypeEnvironment env);
    }
}
