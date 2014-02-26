using System;
using QL.QLClasses.Expressions.Unary;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Binary.Math
{
    public abstract class MathExpression : BinaryExpression
    {
        public override bool CheckType(ref QLTypeError error)
        {
            if (!(LeftExpression.GetResultType().IsCompatibleWithQInt(null) || !RightExpression.GetResultType().IsCompatibleWithQInt(null)))
            {
                error.Message = string.Format("(MathExpression) Expect 2 integers! LeftValue: '{0}', RightValue '{1}'", LeftExpression.GetResultType(), RightExpression.GetResultType());
                error.TokenInfo = LeftExpression.TokenInfo;

                return false;
            }

            return true;
        }

        public override QBaseType GetResultType()
        {
            return LeftExpression.GetResultType();
        }
    }
}
