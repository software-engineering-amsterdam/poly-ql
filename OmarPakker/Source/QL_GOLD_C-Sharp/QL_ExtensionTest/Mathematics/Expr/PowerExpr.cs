using QL_Grammar.AST.Expr;

namespace QL_ExtensionTest.Mathematics.Expr
{
    public class PowerExpr : DoubleExprNode<IExprNode>, IExprNode
    {
        public PowerExpr(IExprNode l, IExprNode r)
            : base(l, r)
        {

        }
    }
}
