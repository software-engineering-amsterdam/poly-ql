using System.Collections.Generic;
using System.Windows.Documents;

namespace Algebra.QL.Print.Expr
{
	public class VarExpr : Algebra.Core.Expr.VarExpr, IPrintExpr
	{
		public VarExpr(string name)
			: base(name)
		{

		}

        public IEnumerable<Inline> BuildDocument()
        {
            return new[] { new Run(Name) };
        }
    }
}
