using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class Pos : UnaryExpression
    {
        public override bool CheckType(ref QLException error)
        {
            if (!(InnerValue.GetResultType() is QInt))
            {
                error.Message = string.Format("The POSITIVE (+) operator can only be applied on integers! Got QType '{0}', with valuetype '{1}'", InnerValue, InnerValue.GetType());
                error.TokenInfo = InnerValue.TokenInfo;

                return false;
            }

            return true;
        }
    }
}
