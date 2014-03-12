using System;
using QL.QLClasses.Values;

namespace QL.QLClasses.Expressions.Binary.Math
{
    public class Div : MathExpression
    {
        public Div(ExpressionBase leftExpression, ExpressionBase rightExpression) 
            : base(leftExpression, rightExpression)
        {
        }

        public override QValue Evaluate()
        {
            return ((IntValue)LeftExpression.Evaluate()).Div((IntValue)RightExpression.Evaluate());
        }
    }
}
