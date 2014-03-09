using System;
using QL.QLClasses.Expressions.Literals;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Binary.Conditional
{
    public class And : BinaryExpression
    {
        public And(ExpressionBase leftExpression, ExpressionBase rightExpression) : base(leftExpression, rightExpression)
        {
        }

        public override ExpressionBase GetResult()
        {
            return new BoolLiteral(Convert.ToBoolean(LeftExpression.GetResult().ToString()) && Convert.ToBoolean(RightExpression.GetResult().ToString()));
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!base.CheckType(typeErrors))
                return false;

            if (!(LeftExpression.GetResultType().IsCompatibleWithQBool(null)) || !(RightExpression.GetResultType().IsCompatibleWithQBool(null)))
            {
                typeErrors.ReportError(new QLTypeError
                {
                    Message = string.Format("Left -or Right Expression is not a boolean. Left: '{0}', Right: '{1}'", LeftExpression.GetResultType(), RightExpression.GetResultType()),
                    TokenInfo = TokenInfo
                });

                return false;
            }

            return true;
        }
    }
}
