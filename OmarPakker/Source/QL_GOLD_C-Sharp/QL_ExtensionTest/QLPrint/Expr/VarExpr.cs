
namespace QL_ExtensionTest.QLPrint.Expr
{
	public class VarExpr : QL_Grammar.QLAlgebra.Expr.VarExpr, IPrintExpr
	{
		public VarExpr(string name)
			: base(name)
		{

		}

        public string BuildDocument()
        {
            return Name;
        }
    }
}
