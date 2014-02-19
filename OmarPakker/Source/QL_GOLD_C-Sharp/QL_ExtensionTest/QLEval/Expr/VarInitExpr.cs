using QL_Grammar.Algebra.Type;
using QL_Grammar.Algebra.Value;
using QL_Grammar.QLAlgebra.Expr;

namespace QL_ExtensionTest.QLEval.Expr
{
    public class VarInitExpr : VarInitExpr<IEvalExpr>, IEvalExpr
    {
        public VarInitExpr(string name, IType type, IEvalExpr value)
            : base(name, type, value)
		{

		}

		public IValue Eval()
		{
			return Value.Eval();
		}
    }
}
