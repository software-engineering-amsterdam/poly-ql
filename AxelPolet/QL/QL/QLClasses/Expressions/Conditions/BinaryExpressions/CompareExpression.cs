using System;
using QL.QLClasses.Expressions.Literals;
using QL.TypeChecker;
using QL.QLClasses.Expressions.Conditions.BinaryExpressions.Operators;

namespace QL.QLClasses.Expressions.Conditions.BinaryExpressions
{
    public class CompareExpression : BinaryExpression
    {
        public OperatorBase CompareOperator { get; set; }

        public override ExpressionBase GetResult()
        {
            return new BoolLiteral(Convert.ToBoolean(CompareOperator.Compare(LeftValue, RightValue)));
        }

        public override bool CheckType(ref QLException error)
        {
            base.CheckType(ref error);

            if (!LeftValue.GetResultType().IsCompatibleWith(RightValue.GetResultType()))
            {
                error.Message = string.Format("Cannot compare values of different types! Left: '{0}', Right: '{1}'", LeftValue.GetResultType(), RightValue.GetResultType());
                error.TokenInfo = LeftValue.TokenInfo;

                return false;
            }

            if (LeftValue.GetResultType().IsCompatibleWithQString(null) && RightValue.GetResultType().IsCompatibleWithQString(null) && !(CompareOperator is Equals))
            {
                error.Message = string.Format("String values can only be compared on equality! CompareOperator: '{0}'", CompareOperator);
                error.TokenInfo = CompareOperator.TokenInfo;

                return false;
            }
            return true;
        }
    }
}
