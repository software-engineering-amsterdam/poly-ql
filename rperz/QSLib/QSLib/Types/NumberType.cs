
namespace QSLib.Types
{
    public class NumberType : QSType
    {
        public override string Name
        {
            get { return "Number"; }
        }

        public override bool IsCompatible(QSType other)
        {
            return other.IsNumber();
        }

        public override bool IsNumber()
        {
            return true;
        }

        public override bool Equals(object obj)
        {
            var temp = obj as NumberType;
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
