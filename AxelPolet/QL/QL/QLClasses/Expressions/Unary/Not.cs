using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class Not : UnaryExpression
    {
        public override bool CheckType(ref QLException error)
        {
            if (!(InnerValue.GetResultType() is QBool))
            {
                error.Message = string.Format("The NOT (!) operator can only be applied on booleans! Got QType '{0}', with valuetype '{1}'", InnerValue, InnerValue.GetType());
                error.TokenInfo = InnerValue.TokenInfo;

                return false;
            }

            return true;
        }
    }
}
