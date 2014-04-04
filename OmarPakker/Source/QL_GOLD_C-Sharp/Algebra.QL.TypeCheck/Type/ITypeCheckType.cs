using Algebra.Core.Type;
using Algebra.QL.TypeCheck.Expr;

namespace Algebra.QL.TypeCheck.Type
{
    public interface ITypeCheckType : ITypeCheck, ITypeBase<ITypeCheckType>
    {
        ITypeCheckExpr DefaultValue { get; }

        bool CompatibleWith(ITypeCheckType other);
    }
}
