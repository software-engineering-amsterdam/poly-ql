using QL_Grammar.QLAlgebra.Stmnt;

namespace QL_ExtensionTest.QLEval.Stmnt
{
    public class FormStmnt : FormStmnt<IEvalStmnt>, IEvalStmnt
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
