using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Binary
{
    public abstract class BinaryExpression : ExpressionBase
    {
        public ExpressionBase LeftExpression { get; set; }
        public ExpressionBase RightExpression { get; set; }

        public override bool CheckType(ref QLTypeError error)
        {
            return LeftExpression.CheckType(ref error) && RightExpression.CheckType(ref error);
        }

        public override QBaseType GetResultType()
        {
            return new QBool();
        }
    }
}
