using System;
using QL.QLClasses.Values;

namespace QL.QLClasses.Expressions.Binary.Math
{
    public class Sub : MathExpression
    {
        public Sub(ExpressionBase leftExpression, ExpressionBase rightExpression) 
            : base(leftExpression, rightExpression)
        {
        }

        public override QValue Evaluate()
        {
            return ((IntValue)LeftExpression.Evaluate()).Sub((IntValue)RightExpression.Evaluate());
        }
    }
}
