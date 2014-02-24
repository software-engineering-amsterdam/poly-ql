using QL_Grammar.QLAlgebra.Stmnt;

namespace QL_ExtensionTest.QLEval.Stmnt
{
    public class CompStmnt : CompStmnt<IEvalStmnt>, IEvalStmnt
    {
        public CompStmnt(params IEvalStmnt[] stmnts)
            : base(stmnts)
        {

        }

        public void Eval()
        {
            foreach (IEvalStmnt stmnt in Statements)
            {
                stmnt.Eval();
            }
        }
    }
}
