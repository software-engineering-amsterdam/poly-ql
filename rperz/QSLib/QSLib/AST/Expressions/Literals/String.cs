using System;
using QSLib.Types;
using QSLib.Values;

namespace QSLib.AST.Expressions.Literals
{
    public class QSString : Primary
    {

        public QSString(String value, int lineNr)
        {
            base._type = new StringType();
            this._value = new StringValue(value);
            this._lineNr = lineNr;
        }

        #region Object overrides
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
        #endregion
    }
}
