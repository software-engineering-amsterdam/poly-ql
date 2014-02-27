using System;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Literals
{
    public class BoolLiteral : ExpressionBase
    {
        private bool _value;

        public BoolLiteral(bool value)
        {
            _value = value;
        }

        public override QBaseType GetResultType()
        {
            return new QBool();
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
