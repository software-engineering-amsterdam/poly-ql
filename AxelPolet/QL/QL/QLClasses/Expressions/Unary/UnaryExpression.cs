using QL.QLClasses.Types;
using QL.QLClasses.Values;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class UnaryExpression : ExpressionBase
    {
        protected ExpressionBase InnerExpression;

        public UnaryExpression(ExpressionBase innerExpression)
        {
            InnerExpression = innerExpression;
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            return InnerExpression.CheckType(typeErrors);
        }

        public override QType GetResultType()
        {
            return InnerExpression.GetResultType();
        }

        public override QValue Evaluate()
        {
            return InnerExpression.Evaluate();
        }
    }
}

