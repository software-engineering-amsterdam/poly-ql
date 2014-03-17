using QL.QLClasses.Types;
using QL.QLClasses.Values;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Literals
{
    public class StringLiteral : ExpressionBase
    {
        private readonly string _value;

        public StringLiteral(string value)
        {
            _value = value;
        }

        public override QType GetResultType()
        {
            return new QString();
        }

        public override QValue Evaluate()
        {
            return new StringValue(_value);
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            return true;
        }

        public override string ToString()
        {
            return _value;
        }
    }
}
