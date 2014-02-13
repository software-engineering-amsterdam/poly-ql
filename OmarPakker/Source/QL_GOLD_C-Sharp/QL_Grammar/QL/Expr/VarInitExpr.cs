using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Types;

namespace QL_Grammar.QL.Expr
{
	public class VarInitExpr : VarInitExprNode<IExprNode>, IExprNode
    {
		public VarInitExpr(string name, IType type, IExprNode value)
            : base(name, type, value)
		{

		}
    }
}
