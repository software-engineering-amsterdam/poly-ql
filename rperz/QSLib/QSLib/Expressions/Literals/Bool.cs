using QSLib.Types;
using QSLib.Expressions.Values;
namespace QSLib.Expressions.Literals
{
    public class QSBoolean : Primary 
    {

        public QSBoolean(bool value, int linenr)
        {
            base._type = new BoolType();
            this._value = new BooleanValue(value);
            this._linenr = linenr;
        }

        public override string ToString()
        {
            return this._value.ToString();
        }

        public override bool Equals(object obj)
        {
            var temp = obj as QSBoolean;
            return temp != null && base.Equals(obj) && this._value.Equals(temp._value);  
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }


    
}
