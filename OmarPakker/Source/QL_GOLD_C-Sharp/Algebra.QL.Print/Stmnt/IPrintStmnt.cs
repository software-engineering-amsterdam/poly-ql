using System.Windows.Documents;
using Algebra.Core.Tree;

namespace Algebra.QL.Print.Stmnt
{
    public interface IPrintStmnt : IPrint, IStmntNode
    {
        Block BuildDocument();
    }
}
