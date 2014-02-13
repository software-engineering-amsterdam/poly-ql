using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Expr;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class VarInitExpr : VarInitExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
		public VarInitExpr(string name, IType type, ITypeCheckExpr value)
            : base(name, type, value)
		{

		}
    }
}
