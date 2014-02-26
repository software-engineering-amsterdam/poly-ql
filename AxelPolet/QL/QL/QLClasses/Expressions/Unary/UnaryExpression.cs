using System;
using QL.QLClasses.Expressions.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class UnaryExpression : ExpressionBase
    {
        public QBaseType InnerValue { get; set; }

        public override object Result()
        {
            return InnerValue.GetValue();
        }

        public override bool CheckType(ref QLException error)
        {
            if (!InnerValue.CheckType(ref error))
                return false;

            return true;
        }

        public override Type GetType()
        {
            return InnerValue.GetType();
        }

        public object GetValue()
        {
            return InnerValue.GetValue();
        }
    }
}

