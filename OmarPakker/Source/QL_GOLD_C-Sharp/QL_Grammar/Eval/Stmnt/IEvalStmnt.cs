using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.Eval.Stmnt
{
    public interface IEvalStmnt : IStmntNode
    {
        void Eval();
    }
}
