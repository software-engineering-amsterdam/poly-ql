using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Literals
{
    public class StringLiteral : ExpressionBase
    {
        private string _value;

        public StringLiteral(string value)
        {
            _value = value;
        }

        public override QBaseType GetResultType()
        {
            return new QString();
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
            return _value;
        }
    }
}
