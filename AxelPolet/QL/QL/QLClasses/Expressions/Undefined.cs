using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions
{
    public class Undefined : ExpressionBase
    {
        private QBaseType _type;

        public Undefined(QBaseType type)
        {
            _type = type;
        }

        public override bool CheckType(QLTypeErrors errors)
        {
            return true;
        }

        public override QBaseType GetResultType()
        {
            return _type;
        }

        public override ExpressionBase GetResult()
        {
            return this;
        }

        public override string ToString()
        {
            if (_type.IsCompatibleWith(new QBool()))
                return "false";

            if (_type.IsCompatibleWith(new QInt()))
                return "0";
            
            return "";
        }
    }
}
