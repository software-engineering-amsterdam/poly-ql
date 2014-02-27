
namespace Algebra.QL.Extensions.Stmnt
{
    public abstract class LoopStmnt<E, S>
    {
        public E Expression { get; private set; }
        public S Body { get; private set; }

        public LoopStmnt(E expr, S body)
        {
            Expression = expr;
            Body = body;
        }
    }
}
