using QL_Grammar.AST.Value;

namespace QL_Grammar.AST.Types
{
    public class NumericType : IType
    {
        public static readonly NumericType Instance = new NumericType();

        public virtual IValue DefaultValue { get { return null; } }

        protected NumericType()
        {

        }

        public bool CompatibleWith(IType other)
        {
            return other is NumericType;
        }

        public override string ToString()
        {
            return "numeric";
        }
    }
}
