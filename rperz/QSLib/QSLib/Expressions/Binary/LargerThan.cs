using QSLib.Types;
using QSLib.Values;
namespace QSLib.Expressions.Binary
{
    class LargerThan : Binary_Expression
    {

        public LargerThan(QSExpression a, QSExpression b, int lineNr)
            : base(a, b, lineNr)
        {
            base._operator = ">";
        }


        public override Value Evaluate()
        {
            this._value = this._left.Evaluate().LargerThan(this._right.Evaluate());
            this.OnPropertyChanged("GetValue");
            return this._value;
        }


        public override QSType Type
        {
            get { return new BoolType(); }
        }
    }
}
