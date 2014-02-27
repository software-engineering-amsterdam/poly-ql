using System.Collections.Generic;
using System.Windows.Documents;
using Algebra.Core.Tree;

namespace Algebra.QL.Print.Expr
{
    public interface IPrintExpr : IPrint, IExprNode
    {
        IEnumerable<Inline> BuildDocument();
    }
}
