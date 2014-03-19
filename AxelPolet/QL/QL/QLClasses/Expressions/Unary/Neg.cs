using QL.QLClasses.Types;
using QL.QLClasses.Values;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class Neg : UnaryExpression
    {
        public Neg(ExpressionBase innerExpression) : base(innerExpression)
        {
        }

        public override QValue Evaluate()
        {
            return new IntValue(((IntValue)InnerExpression.Evaluate()).Value() * -1);
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!(InnerExpression.GetResultType().IsCompatibleWith(new QInt())))
            {
                typeErrors.ReportError(new QLTypeError(
                    string.Format("The NEGATIVE (-) operator can only be applied on integers! Got '{0}'",
                            InnerExpression.GetResultType()), 
                    InnerExpression.TokenInfo
                ));

                return false;
            }

            return true;
        }
    }
}
