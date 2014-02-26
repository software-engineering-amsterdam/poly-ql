using System;

namespace QL.QLClasses.Expressions.Conditions.BinaryExpressions.Operators
{
    public class GrTh : OperatorBase
    {
        public override bool Compare(ExpressionBase leftValue, ExpressionBase rightValue)
        {
            return Convert.ToInt32(leftValue.GetResult()) > Convert.ToInt32(rightValue.GetResult());
        }

        public override string ToString()
        {
            return "Greater than or equals (>)";
        }
    }
}
