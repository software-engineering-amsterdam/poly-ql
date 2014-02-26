using System;

namespace QL.QLClasses.Expressions.Conditions.BinaryExpressions.Operators
{
    public class SmTh : OperatorBase
    {
        public override bool Compare(ExpressionBase leftValue, ExpressionBase rightValue)
        {
            return Convert.ToInt32(leftValue.Result()) < Convert.ToInt32(rightValue.Result());
        }

        public override string ToString()
        {
            return "Smaller than (<)";
        }
    }
}
