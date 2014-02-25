using Antlr4.Runtime;

namespace QL.QLClasses.Expressions.Conditions.BinaryExpressions.Operators
{
    public abstract class OperatorBase
    {
        public abstract bool Compare(ExpressionBase leftValue, ExpressionBase rightValue);

        public int TokenLine { get; set; }
        public int TokenColumn { get; set; }
        public string TokenText { get; set; }

        public IToken Token
        {
            set { TokenLine = value.Line; TokenColumn = value.Column; TokenText = value.Text; }
        }
    }
}
