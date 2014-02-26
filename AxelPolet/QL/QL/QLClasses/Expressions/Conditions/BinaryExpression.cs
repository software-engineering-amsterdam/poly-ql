using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Conditions
{
    public abstract class BinaryExpression : ExpressionBase
    {
        public ExpressionBase LeftValue { get; set; }
        public ExpressionBase RightValue { get; set; }

        public override bool CheckType(ref QLException error)
        {
            return LeftValue.CheckType(ref error) && RightValue.CheckType(ref error);
        }

        public override QBaseType GetResultType()
        {
            return new QBool();
        }
    }
}
