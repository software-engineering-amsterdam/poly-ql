using System;

namespace QL.QLClasses.Expressions.Binary.Compare.Operators
{
    public class GrTh : OperatorBase
    {
        public override bool Compare(ExpressionBase leftValue, ExpressionBase rightValue)
        {
            return Convert.ToInt32(leftValue.Evaluate().ToString()) > Convert.ToInt32(rightValue.Evaluate().ToString());
        }

        public override string ToString()
        {
            return "Greater than or equals (>)";
        }
    }
}
