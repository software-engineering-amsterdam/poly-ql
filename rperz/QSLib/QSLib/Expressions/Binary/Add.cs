﻿using QSLib.Types;
using QSLib.Expressions.Values;
namespace QSLib.Expressions.Binary
{
    public class Add : Binary_Expression  
    {
        public Add(QSExpression a, QSExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "+";
            
        }

        public override Value Evaluate()
        {
            this._value = this._left.Evaluate().Add(this._right.Evaluate());
            this.OnPropertyChanged("GetValue");
            return this._value;
        }

        public override QSType Type
        {
            get { return new NumberType(); }
        }

    }
}