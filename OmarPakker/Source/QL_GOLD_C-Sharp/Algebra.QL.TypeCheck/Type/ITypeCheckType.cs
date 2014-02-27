using Algebra.QL.TypeCheck.Expr;

namespace Algebra.QL.TypeCheck.Type
{
    public interface ITypeCheckType : ITypeCheck
    {
        ITypeCheckType SuperType { get; }
        ITypeCheckExpr DefaultValue { get; }

        ITypeCheckType GetLeastUpperBound(ITypeCheckType other);
        bool CompatibleWith(ITypeCheckType other);
    }
}
