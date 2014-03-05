using System;
using QL.QLClasses.Expressions.Binary.Compare.Operators;
using QL.QLClasses.Expressions.Literals;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Binary.Compare
{
    public class CompareExpression : BinaryExpression
    {
        private readonly OperatorBase _compareOperator;

        public CompareExpression(ExpressionBase leftExpression, ExpressionBase rightExpression, OperatorBase compareOperator) : base(leftExpression, rightExpression)
        {
            _compareOperator = compareOperator;
        }

        public override ExpressionBase GetResult()
        {
            return new BoolLiteral(Convert.ToBoolean(_compareOperator.Compare(LeftExpression, RightExpression)));
        }

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (!base.CheckType(typeErrors))
                return false;

            if (!LeftExpression.GetResultType().IsCompatibleWith(RightExpression.GetResultType()))
            {
                typeErrors.ReportError(new QLTypeError
                {
                    Message = string.Format("Cannot compare values of different types! Left: '{0}', Right: '{1}'",
                            LeftExpression.GetResultType(), RightExpression.GetResultType()), 
                    TokenInfo = LeftExpression.TokenInfo
                });
                return false;
            }

            if (LeftExpression.GetResultType().IsCompatibleWithQString(null) && RightExpression.GetResultType().IsCompatibleWithQString(null) && !(_compareOperator is Equals))
            {
                typeErrors.ReportError(new QLTypeError
                {
                    Message = string.Format("String values can only be compared on equality! _compareOperator: '{0}'",
                            _compareOperator), 
                    TokenInfo = _compareOperator.TokenInfo
                });
                return false;
            }
            return true;
        }
    }
}
