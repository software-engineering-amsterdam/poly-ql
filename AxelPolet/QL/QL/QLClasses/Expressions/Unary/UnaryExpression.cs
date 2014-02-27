using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class UnaryExpression : ExpressionBase
    {
        public ExpressionBase InnerExpression { get; set; }

        public override bool CheckType(ref QLTypeError error)
        {
            return InnerExpression.CheckType(ref error);
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

