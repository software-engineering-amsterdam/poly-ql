namespace QL.QLClasses.Expressions.Binary.Compare.Operators
{
    public class Equals : OperatorBase
    {
        public override bool Compare(ExpressionBase leftValue, ExpressionBase rightValue)
        {
            return leftValue.Evaluate().ToString() == rightValue.Evaluate().ToString();
        }

        public override string ToString()
        {
            return "Equals(==)";
        }
    }
}
