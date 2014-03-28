using QSLib.Types;
using QSLib.Values;

namespace QSLib.AST.Expressions.Binary
{
    class Subtract : Binary_Expression 
    {

        public Subtract(QSExpression a, QSExpression b, int lineNr)
            : base(a, b, lineNr)
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
            get { return new IntegerType(); }
        }

        public override bool IsCompatible(QSType type)
        {
            return type.IsInteger();
        }
    }
}
