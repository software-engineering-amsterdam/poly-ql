using QSLib.Types;
using QSLib.Values;
namespace QSLib.AST.Expressions.Literals
{
    public class QSBoolean : Primary 
    {

        public QSBoolean(bool value, int lineNr)
        {
            base._type = new BoolType();
            this._value = new BooleanValue(value);
            this._lineNr = lineNr;
        }

        #region Object overrides
        public override bool Equals(object obj)
        {
            var temp = obj as QSBoolean;
            return temp != null && base.Equals(obj) && this._value.Equals(temp._value);  
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override string ToString()
        {
            return this._value.ToString();
        }
        #endregion
    }


    
}
