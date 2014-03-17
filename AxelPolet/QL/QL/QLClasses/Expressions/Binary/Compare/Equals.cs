using QL.QLClasses.Values;

namespace QL.QLClasses.Expressions.Binary.Compare
{
    public class Equals : CompareExpression
    {
        public Equals(ExpressionBase leftExpression, ExpressionBase rightExpression) 
            : base(leftExpression, rightExpression)
        {
        }

        public override QValue Evaluate()
        {
            return ((IntValue)LeftExpression.Evaluate()).Equals((IntValue)RightExpression.Evaluate());
        }

        public override string ToString()
        {
            return "Equals(==)";
        }
    }
}
