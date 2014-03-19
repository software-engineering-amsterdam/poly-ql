namespace QL_Csharp
{
    public interface IPrimitiveControl<T>
    {
        void SetValue(T newValue);
        T GetValue();
        void SetReadOnly(bool isReadOnly);
    }
}
