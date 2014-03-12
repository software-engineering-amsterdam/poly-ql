
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
            return other.IsString();
        }

        public override bool IsString()
        {
            return true;
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
    }
}
