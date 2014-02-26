using System;

namespace QL.QLClasses.Expressions.Binary.Compare.Operators
{
    public class SmThEq : OperatorBase
    {
        public override bool Compare(ExpressionBase leftValue, ExpressionBase rightValue)
        {
            return Convert.ToInt32(leftValue.GetResult()) <= Convert.ToInt32(rightValue.GetResult());
        }

        public override string ToString()
        {
            return "Smaller than or equals (<=)";
        }
    }
}
