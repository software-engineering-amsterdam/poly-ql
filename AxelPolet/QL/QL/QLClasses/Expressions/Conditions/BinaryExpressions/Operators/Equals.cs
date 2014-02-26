namespace QL.QLClasses.Expressions.Conditions.BinaryExpressions.Operators
{
    public class Equals : OperatorBase
    {
        public override bool Compare(ExpressionBase leftValue, ExpressionBase rightValue)
        {
            return leftValue.GetResult() == rightValue.GetResult();
        }

        public override string ToString()
        {
            return "Equals(==)";
        }
    }
}
