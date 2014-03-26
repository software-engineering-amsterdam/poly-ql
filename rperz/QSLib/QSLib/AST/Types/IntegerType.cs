using QSLib.Values;
namespace QSLib.Types
{
    public class IntegerType : QSType
    {
        public override string Name
        {
            get { return "Number"; }
        }

        public override bool IsCompatible(QSType other)
        {
            if (other == null)
                return false;
            return other.IsInteger();
        }

        public override bool IsInteger()
        {
            return true;
        }

        public override string ToString()
        {
            return "integer";
        }

        public override bool Equals(object obj)
        {
            var temp = obj as IntegerType;
            if (temp != null)
                return true;
            return false;
        }
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override Value GetUndefinedValue(bool isInput)
        {
            return new IntegerValue(0, isInput);
        }

        public override void CreateGUI(GUIBuilder guiBuilder)
        {
            guiBuilder.CreateIntegerInput();
        }
    }
}
