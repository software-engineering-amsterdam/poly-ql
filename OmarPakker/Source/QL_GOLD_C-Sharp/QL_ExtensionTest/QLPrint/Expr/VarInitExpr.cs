using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Expr;

namespace QL_ExtensionTest.QLPrint.Expr
{
    public class VarInitExpr : VarInitExpr<IPrintExpr>, IPrintExpr
    {
        public VarInitExpr(string name, IType type, IPrintExpr value)
            : base(name, type, value)
		{

		}

        public string BuildDocument()
        {
            return Name + ":" + Type + " = " + Value.BuildDocument();
        }
    }
}
