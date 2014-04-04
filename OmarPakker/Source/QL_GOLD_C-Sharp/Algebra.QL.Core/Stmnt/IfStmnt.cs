
namespace Algebra.QL.Core.Stmnt
{
    public class IfStmnt<E, S>
    {
        public E CheckExpression { get; private set; }
        public S IfTrueBody { get; private set; }

        public IfStmnt(E check, S ifTrue)
        {
            CheckExpression = check;
            IfTrueBody = ifTrue;
        }
    }
}
