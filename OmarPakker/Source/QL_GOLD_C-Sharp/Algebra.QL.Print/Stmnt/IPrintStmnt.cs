using System.Windows.Documents;

namespace Algebra.QL.Print.Stmnt
{
    public interface IPrintStmnt
    {
        Block BuildDocument();
    }
}
