using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class Not : UnaryExpression
    {
        public override bool CheckType(ref QLException error)
        {
            if (InnerValue.GetType() != typeof(bool))
            {
                error.Message = string.Format("The NOT (!) operator can only be applied on booleans! Got QType '{0}', with valuetype '{1}'", InnerValue, InnerValue.GetType());

                error.TokenLine = InnerValue.TokenLine;
                error.TokenColumn = InnerValue.TokenColumn;
                error.TokenText = InnerValue.TokenText;

                return false;
            }

            return true;
        }
    }
}
