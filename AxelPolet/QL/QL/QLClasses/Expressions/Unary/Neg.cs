using System;
using QL.QLClasses.Expressions.Literals;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class Neg : UnaryExpression
    {
        public Neg(ExpressionBase innerExpression) : base(innerExpression)
        {
        }

        public override ExpressionBase GetResult()
        {
            return new IntLiteral(Convert.ToInt32(InnerExpression.GetResult()) * -1);
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!(InnerExpression.GetResultType() is QInt))
            {
                typeErrors.ReportError(new QLTypeError
                {
                    Message = string.Format("The NEGATIVE (-) operator can only be applied on integers! Got QType '{0}', with valuetype '{1}'",
                            InnerExpression, InnerExpression.GetType()),
                    TokenInfo = InnerExpression.TokenInfo
                });

                return false;
            }

            return true;
        }
    }
}
