using QSLib.Types;
using QSLib.Expressions.Values;
using System.ComponentModel;

namespace QSLib.Expressions.Literals
{
    public abstract class Primary : QSExpression
    {
        public override bool CheckType(TypeChecker checker)
        {
            return true;
        }

        public override QSType Type
        {
            get 
            {
                return this._type;
            }
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            var temp = obj as Primary;
            return temp != null && this.Type.IsCompatible(temp.Type);
        }

        public override Value Evaluate()
        {
            this.OnPropertyChanged("GetValue");
            return this._value;
        }
    }
}
