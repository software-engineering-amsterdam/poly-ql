using System.Windows.Documents;

namespace Algebra.QL.Print.Stmnt
{
    public interface IPrintStmnt : IPrint
    {
        Block BuildDocument();
    }
}
