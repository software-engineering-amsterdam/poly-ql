using System.Windows.Documents;

namespace QL_ExtensionTest.QLPrint.Stmnt
{
    public interface IPrintStmnt : IPrint
    {
        Block BuildDocument();
    }
}
