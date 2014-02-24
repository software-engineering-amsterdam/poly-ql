using System;
using QL.QLClasses.Expressions.Unary;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Math
{
    public abstract class MathExpression : ExpressionBase
    {
        public UnaryExpression LeftValue { get; set; }
        public UnaryExpression RightValue { get; set; }

        public override bool CheckType(ref QLException error)
        {
            if (LeftValue.GetType() != RightValue.GetType())
            {
                error.Message = string.Format("(MathExpression) Type mismatch! LeftValue: '{0}', RightValue '{1}'", LeftValue.GetType(), RightValue.GetType());
                error.TokenLine = TokenLine;
                error.TokenColumn = TokenColumn;
                error.TokenText = TokenText;

                return false;
            }

            if (LeftValue.GetType() != typeof(int) && RightValue.GetType() != typeof(int))
            {
                error.Message = string.Format("(MathExpression) Expect 2 integers! LeftValue: '{0}', RightValue '{1}'", LeftValue.GetType(), RightValue.GetType());
                error.TokenLine = TokenLine;
                error.TokenColumn = TokenColumn;
                error.TokenText = TokenText;

                return false;
            }

            return true;
        }

        public override Type GetType()
        {
            return LeftValue.GetType();
        }
    }
}
