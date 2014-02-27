
namespace Algebra.QL.Core.Stmnt
{
    public abstract class CompStmnt<S>
    {
        public S Statement1 { get; private set; }
        public S Statement2 { get; private set; }

        public CompStmnt(S a, S b)
        {
            Statement1 = a;
            Statement2 = b;
        }
    }
}
