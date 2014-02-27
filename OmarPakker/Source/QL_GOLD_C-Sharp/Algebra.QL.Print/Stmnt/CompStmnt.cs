using System.Windows.Documents;
using Algebra.QL.Core.Stmnt;

namespace Algebra.QL.Print.Stmnt
{
    public class CompStmnt : CompStmnt<IPrintStmnt>, IPrintStmnt
    {
        public CompStmnt(IPrintStmnt a, IPrintStmnt b)
            : base(a, b)
        {

        }

        public Block BuildDocument()
        {
            Section s = new Section();
            s.Blocks.Add(Statement1.BuildDocument());
            s.Blocks.Add(Statement2.BuildDocument());
            return s;
        }
    }
}
