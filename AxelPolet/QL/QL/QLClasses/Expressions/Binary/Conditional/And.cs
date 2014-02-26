using System;
using QL.QLClasses.Expressions.Literals;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Binary.Conditional
{
    public class And : BinaryExpression
    {
        public override ExpressionBase GetResult()
        {
            return new BoolLiteral(Convert.ToBoolean(LeftExpression.GetResult()) && Convert.ToBoolean(RightExpression.GetResult()));
        }

        public override bool CheckType(ref QLTypeError error)
        {
            if (!LeftExpression.CheckType(ref error) || !RightExpression.CheckType(ref error))
                return false;

            if (!(LeftExpression.GetResultType().IsCompatibleWithQBool(null)) || !(RightExpression.GetResultType().IsCompatibleWithQBool(null)))
            {
                error.Message = string.Format("Left -or Right Expression is not a boolean. Left: '{0}', Right: '{1}'", LeftExpression.GetResultType(), RightExpression.GetResultType());
                error.TokenInfo = TokenInfo;

                return false;
            }

            return true;
        }
    }
}
