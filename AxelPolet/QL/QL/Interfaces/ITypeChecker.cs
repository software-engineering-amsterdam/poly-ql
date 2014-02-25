using QL.TypeChecker;

namespace QL.Interfaces
{
    public interface ITypeChecker
    {
        bool CheckType(ref QLException error);
    }
}
