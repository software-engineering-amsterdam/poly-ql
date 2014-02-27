using System.Collections.Generic;
using System.Windows.Documents;

namespace Algebra.QL.Print.Expr
{
    public interface IPrintExpr
    {
        IEnumerable<Inline> BuildDocument();
    }
}
