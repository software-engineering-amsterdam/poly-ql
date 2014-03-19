using System;
using QSLib.Types;
using QSLib.Values;

namespace QSLib.AST.Expressions.Binary
{
    class NotEquals : Binary_Expression
    {
        protected new String _operator = "!=";

        public NotEquals(QSExpression a, QSExpression b, int lineNr)
            : base(a, b, lineNr)
        {
            base._operator = "!=";
        }


        public override Value Evaluate()
        {
            this._value = this._left.Evaluate().NotEquals(this._right.Evaluate());
            this.OnPropertyChanged("GetValue");
            return this._value;
        }


        public override QSType Type
        {
            get { return new BoolType(); }
        }
    }
}
