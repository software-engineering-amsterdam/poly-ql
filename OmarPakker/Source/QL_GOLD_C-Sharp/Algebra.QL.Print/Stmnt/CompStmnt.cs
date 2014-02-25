using System.Windows.Documents;
using Algebra.QL.Core.Stmnt;

namespace Algebra.QL.Print.Stmnt
{
    public class CompStmnt : CompStmnt<IPrintStmnt>, IPrintStmnt
    {
        public CompStmnt(params IPrintStmnt[] stmnts)
            : base(stmnts)
        {

        }

        public Block BuildDocument()
        {
            Section s = new Section();

            foreach (IPrintStmnt stmnt in Statements)
            {
                s.Blocks.Add(stmnt.BuildDocument());
            }

            return s;
        }
    }
}
