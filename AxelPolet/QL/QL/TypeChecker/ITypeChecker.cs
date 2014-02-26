namespace QL.TypeChecker
{
    public interface ITypeChecker
    {
        bool CheckType(ref QLTypeError error);
    }
}
