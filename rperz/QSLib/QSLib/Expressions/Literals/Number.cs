using QSLib.Types;
using QSLib.Expressions.Values;
namespace QSLib.Expressions.Literals
{
    public class QSNumber : Primary
    {

        public QSNumber(int value, int linenr)
        {
            base._type = new NumberType();
            this._value = new IntegerValue(value);
            this._linenr = linenr;
        }

        public override string ToString()
        {
            return this._value.ToString();
        }

        public override bool Equals(object obj)
        { 
            var temp = obj as QSNumber;
            return temp != null && base.Equals(obj) && this._value.Equals(temp._value);  
        }


        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }
}
