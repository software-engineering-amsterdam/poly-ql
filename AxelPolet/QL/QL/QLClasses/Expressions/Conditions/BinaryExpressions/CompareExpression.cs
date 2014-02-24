using System;
using QL.TypeChecker;
using QL.QLClasses.Expressions.Conditions.BinaryExpressions.Operators;

namespace QL.QLClasses.Expressions.Conditions.BinaryExpressions
{
    public class CompareExpression : BinaryExpression
    {
        public OperatorBase CompareOperator { get; set; }

        public override object Result()
        {
            return Convert.ToBoolean(CompareOperator.Compare(LeftValue, RightValue));
        }

        public override bool CheckType(ref QLException error)
        {
            base.CheckType(ref error);

            if (LeftValue.GetType() != RightValue.GetType())
            {
                error.Message = string.Format("Cannot compare values of different types! Left: '{0}', Right: '{1}'", LeftValue.GetType(), RightValue.GetType());

                error.TokenLine = LeftValue.TokenLine;
                error.TokenColumn = LeftValue.TokenColumn;
                error.TokenText = LeftValue.TokenText;

                return false;
            }

            if (LeftValue.GetType() == typeof(string) && RightValue.GetType() == typeof(string) && !(CompareOperator is Equals))
            {
                error.Message = string.Format("String values can only be compared on equality! CompareOperator: '{0}'", CompareOperator);

                error.TokenLine = CompareOperator.TokenLine;
                error.TokenColumn = CompareOperator.TokenColumn;
                error.TokenText = CompareOperator.TokenText;

                return false;
            }
            return true;
        }
    }
}
