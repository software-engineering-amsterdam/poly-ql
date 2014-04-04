
namespace Algebra.QL.Core.Stmnt
{
    public class IfElseStmnt<E, S> : IfStmnt<E, S>
    {
        public S IfFalseBody { get; private set; }

        public IfElseStmnt(E check, S ifTrue, S ifFalse)
            : base(check, ifTrue)
        {
            IfFalseBody = ifFalse;
        }
    }
}
