using QSLib.Values;
namespace QSLib.Types
{
    public class StringType : QSType
    {
        public override string Name
        {
            get { return "String"; }
        }

        public override bool IsCompatible(QSType other)
        {
            if (other == null)
                return false;
            return other.IsString();
        }

        public override bool IsString()
        {
            return true;
        }

        public override string ToString()
        {
            return "string";
        }
        
        public override bool Equals(object obj)
        {
            var temp = obj as StringType;
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
            guiBuilder.CreateStringInput();
        }

        public override Value GetUndefinedValue(bool isInput)
        {
            return new StringValue("", isInput);
        }
    }
}
