using QL_Grammar.Algebra.Value;

namespace QL_ExtensionTest.QLEval.Expr
{
	public class VarExpr : QL_Grammar.QLAlgebra.Expr.VarExpr, IEvalExpr
	{
		public VarExpr(string name)
			: base(name)
		{

		}

        public IValue Eval()
        {
            return null; //var lookup
        }
    }
}
