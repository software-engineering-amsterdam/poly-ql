using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class UnaryExpression : ExpressionBase
    {
        protected ExpressionBase InnerExpression;// { get; private set; }

        public UnaryExpression(ExpressionBase innerExpression)
        {
            InnerExpression = innerExpression;
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            return InnerExpression.CheckType(typeErrors);
        }

        public override QBaseType GetResultType()
        {
            return InnerExpression.GetResultType();
        }

        public override ExpressionBase GetResult()
        {
            return InnerExpression.GetResult();
        }
    }
}

