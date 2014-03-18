using QSLib.Values;
namespace QSLib.Types
{
    public class BoolType : QSType
    {
        public override string Name
        {
            get { return "Boolean"; }
        }

        public override bool IsCompatible(QSType other)
        {
            return other.IsBoolean();
        }

        public override bool IsBoolean()
        {
            return true;
        }

        public override Value GetUndefinedValue(bool isInput)
        {
            return new BooleanValue(false, isInput);
        }

        public override bool Equals(object obj)
        {
            var temp = obj as BoolType;
            if (temp != null)
                return true;
            return false;
        }
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override void CreateGUI(GUIBuilder guiBuilder)
        {
            guiBuilder.CreateBooleanInput();
        }
    }
}
