using QL_ExtensionTest.Extensions.Expr;
using QL_ExtensionTest.Extensions.Stmnt;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.Factory;

namespace QL_ExtensionTest.Extensions.Factory
{
	public class ExtensionsFactory : QLFactory, IExtensionsFactory<IExprNode, IStmntNode>
    {
        public IExprNode Modulo(IExprNode l, IExprNode r)
        {
            return new ModuloExpr(l, r);
        }

        public IExprNode Power(IExprNode l, IExprNode r)
        {
            return new PowerExpr(l, r);
        }

		public IStmntNode Loop(IExprNode e, IStmntNode s)
		{
			return new LoopStmnt(e, s);
		}
    }
}
