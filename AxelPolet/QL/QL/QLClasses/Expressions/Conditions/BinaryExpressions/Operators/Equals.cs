namespace QL.QLClasses.Expressions.Conditions.BinaryExpressions.Operators
{
    public class Equals : OperatorBase
    {
        public override bool Compare(ExpressionBase leftValue, ExpressionBase rightValue)
        {
            return leftValue.Result() == rightValue.Result();
        }

        public override string ToString()
        {
            return "Equals(==)";
        }
    }
}
