using Antlr4.Runtime;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Conditions.BinaryExpressions.Operators
{
    public abstract class OperatorBase
    {
        public QLTokenInfo TokenInfo { get; private set; }
        public IToken Token { set { TokenInfo = new QLTokenInfo(value); } }

        public abstract bool Compare(ExpressionBase leftValue, ExpressionBase rightValue);
    }
}
