using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Binary.Conditional
{
    public abstract class ConditionalExpression : BinaryExpression
    {
        protected ConditionalExpression(ExpressionBase leftExpression, ExpressionBase rightExpression) 
            : base(leftExpression, rightExpression)
        {
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!base.CheckType(typeErrors))
                return false;

            if (!(LeftExpression.GetResultType().IsCompatibleWith(new QBool()))
                || !(RightExpression.GetResultType().IsCompatibleWith(new QBool())))
            {
                typeErrors.ReportError(new QLTypeError(
                string.Format("Left -or right expression is not a boolean. Left value: '{0}', right value: '{1}'",
                    LeftExpression.GetResultType(), RightExpression.GetResultType()),
                    TokenInfo = TokenInfo
                ));

                return false;
            }

            return true;
        }
    }
}
