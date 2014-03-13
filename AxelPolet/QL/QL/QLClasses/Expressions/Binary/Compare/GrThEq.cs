using QL.QLClasses.Values;

namespace QL.QLClasses.Expressions.Binary.Compare
{
    public class GrThEq : CompareExpression
    {
        public GrThEq(ExpressionBase leftExpression, ExpressionBase rightExpression) 
            : base(leftExpression, rightExpression)
        {
        }

        public override QValue Evaluate()
        {
            return ((IntValue)LeftExpression.Evaluate()).GrThEq((IntValue)RightExpression.Evaluate());
        }

        public override string ToString()
        {
            return "Greater than or equals (>=)";
        }
    }
}
