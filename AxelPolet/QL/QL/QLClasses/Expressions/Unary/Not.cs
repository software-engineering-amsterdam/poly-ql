using System;
using QL.QLClasses.Expressions.Literals;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class Not : UnaryExpression
    {
        public override ExpressionBase GetResult()
        {
            return new BoolLiteral(!Convert.ToBoolean(InnerExpression.GetResult()));
        }

        public override bool CheckType(ref QLTypeError error)
        {
            if (!(InnerExpression.GetResultType() is QBool))
            {
                error.Message = string.Format("The NOT (!) operator can only be applied on booleans! Got QType '{0}', with valuetype '{1}'", InnerExpression, InnerExpression.GetType());
                error.TokenInfo = InnerExpression.TokenInfo;

                return false;
            }

            return true;
        }
    }
}
