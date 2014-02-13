
namespace QL_Grammar.QLTypeCheck.Expr
{
	public class VarExpr : QL_Grammar.QLAlgebra.Expr.VarExpr, ITypeCheckExpr
	{
		public VarExpr(string name)
			: base(name)
		{

		}
	}
}
