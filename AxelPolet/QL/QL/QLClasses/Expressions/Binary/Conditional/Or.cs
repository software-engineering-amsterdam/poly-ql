using QL.QLClasses.Values;

namespace QL.QLClasses.Expressions.Binary.Conditional
{
    public class Or : ConditionalExpression
    {
        public Or(ExpressionBase leftExpression, ExpressionBase rightExpression) 
            : base(leftExpression, rightExpression)
        {
        }

        public override QValue Evaluate()
        {
            return ((BoolValue)LeftExpression.Evaluate()).Or((BoolValue)RightExpression.Evaluate());
        }
    }
}
