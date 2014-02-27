using System;
using QL.QLClasses.Expressions.Binary.Compare.Operators;
using QL.QLClasses.Expressions.Literals;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Binary.Compare
{
    public class CompareExpression : BinaryExpression
    {
        public OperatorBase CompareOperator { get; set; }

        public override ExpressionBase GetResult()
        {
            return new BoolLiteral(Convert.ToBoolean(CompareOperator.Compare(LeftExpression, RightExpression)));
        }

        public override bool CheckType(ref QLTypeError error)
        {
            base.CheckType(ref error);

            if (!LeftExpression.GetResultType().IsCompatibleWith(RightExpression.GetResultType()))
            {
                error.Message = string.Format("Cannot compare values of different types! Left: '{0}', Right: '{1}'", LeftExpression.GetResultType(), RightExpression.GetResultType());
                error.TokenInfo = LeftExpression.TokenInfo;

                return false;
            }

            if (LeftExpression.GetResultType().IsCompatibleWithQString(null) && RightExpression.GetResultType().IsCompatibleWithQString(null) && !(CompareOperator is Equals))
            {
                error.Message = string.Format("String values can only be compared on equality! CompareOperator: '{0}'", CompareOperator);
                error.TokenInfo = CompareOperator.TokenInfo;

                return false;
            }
            return true;
        }
    }
}
