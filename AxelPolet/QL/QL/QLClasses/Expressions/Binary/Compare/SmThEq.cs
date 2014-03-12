using QL.QLClasses.Values;

namespace QL.QLClasses.Expressions.Binary.Compare
{
    public class SmThEq : CompareExpression
    {
        public SmThEq(ExpressionBase leftExpression, ExpressionBase rightExpression) 
            : base(leftExpression, rightExpression)
        {
        }

        public override QValue Evaluate()
        {
            return ((IntValue)LeftExpression.Evaluate()).SmThEq((IntValue)RightExpression.Evaluate());
        }

        public override string ToString()
        {
            return "Smaller than or equals (<=)";
        }
    }
}
