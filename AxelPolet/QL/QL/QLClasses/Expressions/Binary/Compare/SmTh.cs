using QL.QLClasses.Values;

namespace QL.QLClasses.Expressions.Binary.Compare
{
    public class SmTh : CompareExpression
    {
        public SmTh(ExpressionBase leftExpression, ExpressionBase rightExpression) 
            : base(leftExpression, rightExpression)
        {
        }

        public override QValue Evaluate()
        {
            return ((IntValue)LeftExpression.Evaluate()).SmTh((IntValue)RightExpression.Evaluate());
        }

        public override string ToString()
        {
            return "Smaller than (<)";
        }
    }
}
