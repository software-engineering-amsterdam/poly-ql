using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class Neg : UnaryExpression
    {
        public override bool CheckType(ref QLException error)
        {
            if (InnerValue.GetType() != typeof(int))
            {
                error.Message = string.Format("The NEGATIVE (-) operator can only be applied on integers! Got QType '{0}', with valuetype '{1}'", InnerValue, InnerValue.GetType());

                error.TokenLine = InnerValue.TokenLine;
                error.TokenColumn = InnerValue.TokenColumn;
                error.TokenText = InnerValue.TokenText;

                return false;
            }

            return true;
        }
    }
}
