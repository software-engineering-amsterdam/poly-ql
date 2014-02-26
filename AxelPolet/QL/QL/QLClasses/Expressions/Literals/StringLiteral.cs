using System;
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
            return null;
        }

        public override bool CheckType(ref QLTypeError error)
        {
            return true;
        }
    }
}
