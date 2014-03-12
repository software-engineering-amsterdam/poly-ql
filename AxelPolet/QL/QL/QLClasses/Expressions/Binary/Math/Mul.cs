using System;
using QL.QLClasses.Values;

namespace QL.QLClasses.Expressions.Binary.Math
{
    public class Mul : MathExpression
    {
        public Mul(ExpressionBase leftExpression, ExpressionBase rightExpression) 
            : base(leftExpression, rightExpression)
        {
        }

        public override QValue Evaluate()
        {
            return ((IntValue)LeftExpression.Evaluate()).Mul((IntValue)RightExpression.Evaluate());
        }
    }
}
