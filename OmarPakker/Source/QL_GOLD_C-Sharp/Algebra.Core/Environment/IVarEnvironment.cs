
namespace Algebra.Core.Environment
{
    public interface IVarEnvironment<T>
    {
        void Declare(string name, T value);
        bool IsDeclared(string name);
        T GetDeclared(string name);
        void Clear();
    }
}
