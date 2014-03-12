using System;
using QL.QLClasses.Types;
using QL.QLClasses.Values;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class Not : UnaryExpression
    {
        public Not(ExpressionBase innerExpression) : base(innerExpression)
        {
        }

        public override QValue Evaluate()
        {
            return new BoolValue(!((BoolValue)InnerExpression.Evaluate()).GetValue());
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!(InnerExpression.GetResultType().IsCompatibleWith(new QBool())))
            {
                typeErrors.ReportError(new QLTypeError
                {
                    Message = string.Format("The NOT (!) operator can only be applied on booleans! Got QType '{0}', with valuetype '{1}'",
                            InnerExpression, InnerExpression.GetType()), TokenInfo = InnerExpression.TokenInfo
                });

                return false;
            }

            return true;
        }
    }
}
