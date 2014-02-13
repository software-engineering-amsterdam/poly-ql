using QL_ExtensionTest.Mathematics.Expr;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.Factory;

namespace QL_ExtensionTest.Mathematics.Factory
{
    public class MathFactory : QLFactory, IMathFactory<IExprNode, IStmntNode>
    {
        public IExprNode Modulo(IExprNode l, IExprNode r)
        {
            return new ModuloExpr(l, r);
        }

        public IExprNode Power(IExprNode l, IExprNode r)
        {
            return new PowerExpr(l, r);
        }
    }
}
