using Algebra.QL.TypeCheck.Environment;

namespace Algebra.QL.TypeCheck.Stmnt
{
    public interface ITypeCheckStmnt : ITypeCheck
    {
        void TypeCheck(TypeEnvironment env);
    }
}
