using System;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Conditions.BinaryExpressions
{
    public class And : BinaryExpression
    {
        public override object Result()
        {
            return Convert.ToBoolean(LeftValue.Result()) && Convert.ToBoolean(RightValue.Result());
        }

        public override bool CheckType(ref QLException error)
        {
            if (!LeftValue.CheckType(ref error) || !RightValue.CheckType(ref error))
                return false;

            if (LeftValue.GetType() != typeof(bool) || RightValue.GetType() != typeof(bool))
            {
                error.Message = string.Format("Left -or Right Expression is not a boolean. Left: '{0}', Right: '{1}'", LeftValue.GetType(), RightValue.GetType());

                error.TokenLine = TokenLine;
                error.TokenColumn = TokenColumn;
                error.TokenText = TokenText;

                return false;
            }

            return true;
        }
    }
}
