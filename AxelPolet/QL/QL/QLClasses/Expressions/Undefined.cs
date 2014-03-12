using QL.QLClasses.Types;
using QL.QLClasses.Values;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions
{
    public class Undefined : ExpressionBase
    {
        private readonly QType _type;

        public Undefined(QType type)
        {
            _type = type;
        }

        public override bool CheckType(QLTypeErrors errors)
        {
            return true;
        }

        public override QType GetResultType()
        {
            return _type;
        }

        public override QValue Evaluate()
        {
            if (_type.IsCompatibleWith(new QBool()))
                return new BoolValue(false);

            if (_type.IsCompatibleWith(new QInt()))
                return new IntValue(0);

            return new StringValue("");
        }
    }
}
