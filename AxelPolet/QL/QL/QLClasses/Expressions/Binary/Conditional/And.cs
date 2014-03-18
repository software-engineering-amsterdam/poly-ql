using QL.QLClasses.Values;

namespace QL.QLClasses.Expressions.Binary.Conditional
{
    public class And : ConditionalExpression
    {
        public And(ExpressionBase leftExpression, ExpressionBase rightExpression) 
            : base(leftExpression, rightExpression)
        {
        }

        public override QValue Evaluate()
        {
            return ((BoolValue)LeftExpression.Evaluate()).And((BoolValue)RightExpression.Evaluate());
        }
    }
}
