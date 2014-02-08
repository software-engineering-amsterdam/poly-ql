using QL_Grammar.AST.Value;

namespace QL_Grammar.AST.Expr
{
    public class LiteralExprNode : IExprNode
    {
        public IValue Value { get; private set; }

        public LiteralExprNode(IValue value)
        {
            Value = value;
        }
    }
}
