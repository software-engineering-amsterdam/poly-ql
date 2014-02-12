using QL_Grammar.AST.Value;

namespace QL_Grammar.AST.Types
{
    public interface IType
    {
        IValue DefaultValue { get; }

        bool CompatibleWith(IType other);
    }
}
