
namespace Algebra.QL.Core.Factory
{
    public interface IStmntFactory<S, E, T> : Algebra.Core.Factory.IStmntFactory<S, E, T>, IExprFactory<E, T>
    {
        S Statements(S l, S r);

        S Form(string var, S s);
        S Question(string s, E e);
        S Label(string s, E e);
        S If(E toEval, S ifTrue);
        S IfElse(E toEval, S ifTrue, S ifFalse);
    }
}
