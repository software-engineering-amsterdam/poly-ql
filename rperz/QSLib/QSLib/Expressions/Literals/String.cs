using System;
using QSLib.Types;
using QSLib.Values;

namespace QSLib.Expressions.Literals
{
    public class QSString : Primary
    {

        public QSString(String value, int linenr)
        {
            base._type = new StringType();
            this._value = new StringValue(value);
            this._linenr = linenr;
        }

        public override bool Equals(object obj)
        {
            var temp = obj as QSString;
            return temp != null && base.Equals(obj) && this._value.Equals(temp._value);
        }

        public override string ToString()
        {
            return this._value.ToString().Replace('\"', ' ');
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }
}
