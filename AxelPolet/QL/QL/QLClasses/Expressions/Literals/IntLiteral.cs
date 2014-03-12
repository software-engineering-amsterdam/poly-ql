using QL.QLClasses.Types;
using QL.QLClasses.Values;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Literals
{
    public class IntLiteral : ExpressionBase
    {
        private readonly int _value;

        public IntLiteral(int value)
        {
            _value = value;
        }

        public override QType GetResultType()
        {
            return new QInt();
        }

        public override QValue Evaluate()
        {
            return new IntValue(_value);
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            return true;
        }

        public override string ToString()
        {
            return _value.ToString();
        }
    }
}
