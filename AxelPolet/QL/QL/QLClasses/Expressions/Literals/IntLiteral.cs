using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Literals
{
    public class IntLiteral : ExpressionBase
    {
        private int _value;

        public IntLiteral(int value)
        {
            _value = value;
        }

        public override QBaseType GetResultType()
        {
            return new QInt();
        }

        public override ExpressionBase GetResult()
        {
            return this;
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
