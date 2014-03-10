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
            return new IntLiteral(Convert.ToInt32(LeftExpression.GetResult().ToString()) + Convert.ToInt32((RightExpression.GetResult().ToString())));
        }
    }
}
