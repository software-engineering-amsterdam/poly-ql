using QSLib.Types;
using QSLib.Values;
using System.ComponentModel;

namespace QSLib.Expressions.Binary
{
    class Subtract : Binary_Expression 
    {

        public Subtract(QSExpression a, QSExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "-";
        }


        public override Value Evaluate()
        {
            this._value = this._left.Evaluate().Subtract(this._right.Evaluate());
            this.OnPropertyChanged("GetValue");
            return this._value;
        }


        public override QSType Type
        {
            get { return new NumberType(); }
        }
    }
}
