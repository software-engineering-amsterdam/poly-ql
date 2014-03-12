using QL.QLClasses.Values;

namespace QL.QLClasses.Expressions.Binary.Math
{
    public class Add : MathExpression
    {
        public Add(ExpressionBase leftExpression, ExpressionBase rightExpression) 
            : base(leftExpression, rightExpression)
        {
        }

        public override QValue Evaluate()
        {
            return ((IntValue)LeftExpression.Evaluate()).Add((IntValue) RightExpression.Evaluate());
        }
    }
}
