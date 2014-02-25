
namespace Algebra.QL.Print.Expr
{
	public class VarExpr : Algebra.QL.Core.Expr.VarExpr, IPrintExpr
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
