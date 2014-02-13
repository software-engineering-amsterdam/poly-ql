using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.Factory;

namespace QL_ExtensionTest.Mathematics.Factory
{
    public interface IMathFactory<E, S> : IFactory<E, S>
        where E : IExprNode
        where S : IStmntNode
    {
        E Modulo(E l, E r);
        E Power(E l, E r);
    }
}
