using System.Collections.Generic;
using System.Windows.Documents;
using Algebra.Core.Expr;
using Algebra.QL.Print.Type;

namespace Algebra.QL.Print.Expr
{
    public class VarInitExpr : VarInitExpr<IPrintExpr, IPrintType>, IPrintExpr
    {
        public VarInitExpr(string name, IPrintType type, IPrintExpr value)
            : base(name, type, value)
		{

		}

        public IEnumerable<Inline> BuildDocument()
        {
            List<Inline> inlines = new List<Inline>
            {
                new Run(Name + ":"),
                Type.BuildDocument(),
                new Run(" = ")
            };
            inlines.AddRange(Value.BuildDocument());
            return inlines;
        }
    }
}
