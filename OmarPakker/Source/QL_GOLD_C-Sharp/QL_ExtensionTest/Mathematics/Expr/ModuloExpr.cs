using QL_Grammar.AST.Expr;

namespace QL_ExtensionTest.Mathematics.Expr
{
    public class ModuloExpr : DoubleExprNode<IExprNode>, IExprNode
    {
        public ModuloExpr(IExprNode l, IExprNode r)
            : base(l, r)
        {

        }
    }
}
