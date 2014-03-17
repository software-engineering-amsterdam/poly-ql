using QSLib.Types;
using QSLib.Expressions.Values;
using System.ComponentModel;
namespace QSLib.Expressions.Binary
{
    public class Divide : Binary_Expression 
    {
        public Divide(QSExpression a, QSExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "/";
        }


        public override Value Evaluate()
        {
            this._value = this._left.Evaluate().Divide(this._right.Evaluate());
            this.OnPropertyChanged("GetValue");
            return this._value;
        }


        public override QSType Type
        {
            get { return new NumberType(); }
        }
    }
}
