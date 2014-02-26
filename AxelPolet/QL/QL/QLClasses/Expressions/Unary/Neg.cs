using System;
using QL.QLClasses.Expressions.Literals;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class Neg : UnaryExpression
    {
        public override ExpressionBase GetResult()
        {
            return new IntLiteral(Convert.ToInt32(InnerExpression.GetResult()) * -1);
        }

        public override bool CheckType(ref QLTypeError error)
        {
            if (!(InnerExpression.GetResultType() is QInt))
            {
                error.Message = string.Format("The NEGATIVE (-) operator can only be applied on integers! Got QType '{0}', with valuetype '{1}'", InnerExpression, InnerExpression.GetType());
                error.TokenInfo = InnerExpression.TokenInfo;

                return false;
            }

            return true;
        }
    }
}
