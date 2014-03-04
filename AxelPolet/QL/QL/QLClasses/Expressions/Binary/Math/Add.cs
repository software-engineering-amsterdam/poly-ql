using System;
using QL.QLClasses.Expressions.Literals;

namespace QL.QLClasses.Expressions.Binary.Math
{
    public class Add : MathExpression
    {
        public Add(ExpressionBase leftExpression, ExpressionBase rightExpression) : base(leftExpression, rightExpression)
        {
        }

        public override ExpressionBase GetResult()
        {
            //return Convert.ToInt32(LeftValue.GetResult()) + Convert.ToInt32(RightValue.GetResult());
            return new IntLiteral(Convert.ToInt32(LeftExpression.GetResult()) + Convert.ToInt32((RightExpression.GetResult())));
        }
    }
}
