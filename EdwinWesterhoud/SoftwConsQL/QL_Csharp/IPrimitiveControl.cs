namespace QL_Csharp.PrimitiveControls
{
    public interface IPrimitiveControl<T>
    {
        void SetValue(T newValue);
        T GetValue();
        void SetReadOnly(bool isReadOnly);
    }
}
