using System.Windows.Documents;

namespace QL_ExtensionTest.QLPrint.Expr
{
    public interface IPrintExpr : IPrint
    {
        string BuildDocument();
    }
}
