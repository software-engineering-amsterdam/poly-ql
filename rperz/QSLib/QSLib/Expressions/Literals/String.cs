using System;
using QSLib.Types;
namespace QSLib.Expressions.Literals
{
    public class QSString : Primary
    {
        private String _value;

        public QSString(String value, int linenr)
        {
            base._type = new StringType();
            this._value = value;
            this._linenr = linenr;
        }

        public object GetValue()
        {
            return this._value;
        }


        public override bool Equals(object obj)
        {
            var temp = obj as QSString;
            return temp != null && base.Equals(obj) && this._value.Equals(temp._value);
        }

        public override string ToString()
        {
            return this._value.ToString();
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }
}
