
namespace Algebra.QL.Extensions.Stmnt
{
    public abstract class RepeatStmnt<E, S>
    {
        public E Expression { get; private set; }
        public S Body { get; private set; }

        public RepeatStmnt(E expr, S body)
        {
            Expression = expr;
            Body = body;
        }
    }
}
