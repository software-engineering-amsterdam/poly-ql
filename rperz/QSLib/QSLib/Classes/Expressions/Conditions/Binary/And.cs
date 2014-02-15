using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Conditions.Binary
{
    class And : Boolean_Expression
    {
        private Expression _left;
        private Expression _right;
        private Type type_left;
        private Type type_right;

        public override Type GetType()
        {
            if (this._left.GetType().Equals(this._right.GetType()))
                return this._left.GetType();
            else
                return null;
        }
    }
}
