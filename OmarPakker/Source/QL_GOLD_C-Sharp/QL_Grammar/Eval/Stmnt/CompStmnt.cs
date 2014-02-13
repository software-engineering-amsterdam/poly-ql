using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.Eval.Stmnt
{
    public class CompStmnt : CompStmntNode<IEvalStmnt>, IEvalStmnt
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
