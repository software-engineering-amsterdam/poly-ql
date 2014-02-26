using System;
using QL.QLClasses.Expressions.Literals;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Conditions.BinaryExpressions
{
    public class And : BinaryExpression
    {
        public override ExpressionBase GetResult()
        {
            return new BoolLiteral(Convert.ToBoolean(LeftValue.GetResult()) && Convert.ToBoolean(RightValue.GetResult()));
        }

        public override bool CheckType(ref QLException error)
        {
            if (!LeftValue.CheckType(ref error) || !RightValue.CheckType(ref error))
                return false;

            if (!(LeftValue.GetResultType().IsCompatibleWithQBool(null)) || !(RightValue.GetResultType().IsCompatibleWithQBool(null)))
            {
                error.Message = string.Format("Left -or Right Expression is not a boolean. Left: '{0}', Right: '{1}'", LeftValue.GetResultType(), RightValue.GetResultType());
                error.TokenInfo = TokenInfo;

                return false;
            }

            return true;
        }
    }
}
