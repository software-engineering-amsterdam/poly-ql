using System;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Unary
{
    public class UnaryExpression : ExpressionBase
    {
        public ExpressionBase InnerValue { get; set; }

        public override bool CheckType(ref QLException error)
        {
            return InnerValue.CheckType(ref error);
        }

        public override QBaseType GetResultType()
        {
            return InnerValue.GetResultType();
        }

        public override ExpressionBase GetResult()
        {
            return InnerValue.GetResult();
        }
    }
}

