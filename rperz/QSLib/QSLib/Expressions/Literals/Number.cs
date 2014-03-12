using QSLib.Types;

namespace QSLib.Expressions.Literals
{
    public class QSNumber : Primary
    {
        private int _value;

        public QSNumber(int value, int linenr)
        {
            base._type = new NumberType();
            this._value = value;
            this._linenr = linenr;
        }

        public object GetValue()
        {
            return this._value;
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
