using System.Windows.Documents;

namespace Algebra.QL.Print.Expr
{
    public interface IPrintExpr : IPrint
    {
        string BuildDocument();
    }
}
