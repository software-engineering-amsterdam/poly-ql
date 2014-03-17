using QSLib.Types;
using QSLib.Expressions.Values;
using System.ComponentModel;

namespace QSLib.Expressions.Binary
{
    public class LargerThan_Equals : Binary_Expression
    {

        public LargerThan_Equals(QSExpression a, QSExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = ">=";
        }

        public override Value Evaluate()
        {
            this._value = this._left.Evaluate().LargerThan_Equals(this._right.Evaluate());
            this.OnPropertyChanged("GetValue");
            return this._value;
        }

        public override QSType Type
        {
            get { return new BoolType(); }
        }
    }
}
