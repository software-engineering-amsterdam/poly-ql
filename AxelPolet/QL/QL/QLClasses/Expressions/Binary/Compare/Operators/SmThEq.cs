using System;

namespace QL.QLClasses.Expressions.Binary.Compare.Operators
{
    public class SmThEq : OperatorBase
    {
        public override bool Compare(ExpressionBase leftValue, ExpressionBase rightValue)
        {
            return Convert.ToInt32(leftValue.GetResult().ToString()) <= Convert.ToInt32(rightValue.GetResult().ToString());
        }

        public override string ToString()
        {
            return "Smaller than or equals (<=)";
        }
    }
}
