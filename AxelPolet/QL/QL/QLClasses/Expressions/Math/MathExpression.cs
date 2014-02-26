using System;
using QL.QLClasses.Expressions.Unary;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Math
{
    public abstract class MathExpression : ExpressionBase
    {
        public UnaryExpression LeftValue { get; set; }
        public UnaryExpression RightValue { get; set; }

        public override bool CheckType(ref QLException error)
        {
            if (!(LeftValue.GetResultType().IsCompatibleWithQInt(null) || !RightValue.GetResultType().IsCompatibleWithQInt(null)))
            {
                error.Message = string.Format("(MathExpression) Expect 2 integers! LeftValue: '{0}', RightValue '{1}'", LeftValue.GetResultType(), RightValue.GetResultType());
                error.TokenInfo = LeftValue.TokenInfo;

                return false;
            }

            return true;
        }

        public override QBaseType GetResultType()
        {
            return LeftValue.GetResultType();
        }
    }
}
