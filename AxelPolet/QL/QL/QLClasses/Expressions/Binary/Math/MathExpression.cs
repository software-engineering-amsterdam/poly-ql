using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Binary.Math
{
    public abstract class MathExpression : BinaryExpression
    {
        protected MathExpression(ExpressionBase leftExpression, ExpressionBase rightExpression) 
            : base(leftExpression, rightExpression)
        {
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!base.CheckType(typeErrors))
                return false;

            if (!LeftExpression.GetResultType().IsCompatibleWith(new QInt()) || 
                !RightExpression.GetResultType().IsCompatibleWith(new QInt()))
            {
                typeErrors.ReportError(new QLTypeError(
                    string.Format("Can only apply math on 2 integers! Left value: '{0}', right value '{1}'",
                        LeftExpression.GetResultType(), RightExpression.GetResultType()),
                    LeftExpression.TokenInfo
                    ));
                return false;
            }

            return true;
        }

        public override QType GetResultType()
        {
            return LeftExpression.GetResultType();
        }
    }
}
