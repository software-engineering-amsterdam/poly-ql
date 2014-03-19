using QL.QLClasses.Values;

namespace QL.QLClasses.Expressions.Binary.Compare
{
    public class GrTh : CompareExpression
    {
        public GrTh(ExpressionBase leftExpression, ExpressionBase rightExpression) 
            : base(leftExpression, rightExpression)
        {
        }

        public override QValue Evaluate()
        {
            return ((IntValue)LeftExpression.Evaluate()).GrTh((IntValue)RightExpression.Evaluate());
        }

        public override string ToString()
        {
            return "Greater than or equals (>)";
        }
    }
}
