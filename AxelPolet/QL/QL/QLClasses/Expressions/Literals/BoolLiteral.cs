using QL.QLClasses.Types;
using QL.QLClasses.Values;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Literals
{
    public class BoolLiteral : ExpressionBase
    {
        private readonly bool _value;

        public BoolLiteral(bool value)
        {
            _value = value;
        }

        public override QType GetResultType()
        {
            return new QBool();
        }

        public override QValue Evaluate()
        {
            return new BoolValue(_value);
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
