using QL.QLClasses.Types;
using QL.QLClasses.Values;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class Pos : UnaryExpression
    {
        public Pos(ExpressionBase innerExpression) : base(innerExpression)
        {
        }

        public override QValue Evaluate()
        {
            return InnerExpression.Evaluate();
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!(InnerExpression.GetResultType().IsCompatibleWith(new QInt())))
            {
                typeErrors.ReportError(new QLTypeError()
                {
                    Message = string.Format( "The POSITIVE (+) operator can only be applied on integers! Got QType '{0}', with valuetype '{1}'",
                            InnerExpression, InnerExpression.GetType()), TokenInfo = InnerExpression.TokenInfo
                });

                return false;
            }

            return true;
        }
    }
}
