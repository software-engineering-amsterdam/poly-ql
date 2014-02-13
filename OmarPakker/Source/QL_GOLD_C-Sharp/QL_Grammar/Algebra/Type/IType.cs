using QL_Grammar.Algebra.Value;

namespace QL_Grammar.Algebra.Type
{
    public interface IType
    {
        IValue DefaultValue { get; }

        bool CompatibleWith(IType other);
    }
}
