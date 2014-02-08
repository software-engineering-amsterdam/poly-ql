using System.Collections.Generic;
using System.Collections.ObjectModel;
using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.Eval.Stmnt
{
    public class GotoStmnt : GotoStmntNode, IEvalStmnt
    {
        public ReadOnlyDictionary<string, IEvalStmnt> Forms { get; private set; }

        public GotoStmnt(string gotoName, Dictionary<string, IEvalStmnt> forms)
            : base(gotoName)
		{
            Forms = new ReadOnlyDictionary<string, IEvalStmnt>(forms);
		}

        public void Eval()
        {
            Forms[GotoName].Eval();
        }
    }
}
