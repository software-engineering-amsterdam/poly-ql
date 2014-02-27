
namespace Algebra.Core.Expr
{
	public class VarExpr
	{
		public string Name { get; private set; }

		public VarExpr(string name)
		{
			Name = name;
		}
	}
}
