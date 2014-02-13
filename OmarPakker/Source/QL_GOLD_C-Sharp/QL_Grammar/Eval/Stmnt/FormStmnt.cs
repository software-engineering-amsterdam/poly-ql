using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.Eval.Stmnt
{
    public class FormStmnt : FormStmntNode<IEvalStmnt>, IEvalStmnt
    {
        public FormStmnt(string name, IEvalStmnt body)
            : base(name, body)
        {

        }

        public void Eval()
        {
            Body.Eval();
        }
    }
}
