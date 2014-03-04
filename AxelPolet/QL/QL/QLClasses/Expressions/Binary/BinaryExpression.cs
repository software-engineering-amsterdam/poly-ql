using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Binary
{
    public abstract class BinaryExpression : ExpressionBase
    {
        protected ExpressionBase LeftExpression; //{ get; set; }
        protected ExpressionBase RightExpression; //{ get; set; }

        public BinaryExpression(ExpressionBase leftExpression, ExpressionBase rightExpression)
        {
            LeftExpression = leftExpression;
            RightExpression = rightExpression;
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            return LeftExpression.CheckType(typeErrors) && RightExpression.CheckType(typeErrors);
        }

        public override QBaseType GetResultType()
        {
            return new QBool();
        }
    }
}
