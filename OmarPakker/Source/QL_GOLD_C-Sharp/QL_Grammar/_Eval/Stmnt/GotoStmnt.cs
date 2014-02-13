using System.Collections.ObjectModel;
using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.Eval.Stmnt
{
    public class GotoStmnt : GotoStmntNode, IEvalStmnt
    {
        public ReadOnlyDictionary<string, IEvalStmnt> Forms { get; private set; }

        public GotoStmnt(string gotoName, ReadOnlyDictionary<string, IEvalStmnt> forms)
            : base(gotoName)
		{
            Forms = forms;
		}

        public void Eval()
        {
            Forms[GotoName].Eval();
        }
    }
}
