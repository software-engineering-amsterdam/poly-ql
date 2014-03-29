using QSLib.Values;
namespace QSLib.Types
{
    public abstract class QSType 
    {
        public abstract string Name { get; }

        public virtual bool IsCompatible(QSType other)
        {
            return false;
        }

        public virtual bool IsBoolean()
        {
            return false;
        }

        public virtual bool IsString()
        {
            return false;
        }

        public virtual bool IsInteger()
        {
            return false;
        }

        public abstract Value GetUndefinedValue(bool isInput);

        public abstract void CreateGUI(GUIBuilder guiBuilder);
    }
}
