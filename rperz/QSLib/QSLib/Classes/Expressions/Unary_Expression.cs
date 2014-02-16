using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions
{
    public class Unary_Expression : Expression
    {
        protected Expression _left;
        protected Type _typeLeft;

        public override Type GetType()
        {
            if (this._typeLeft != null)
                return this._typeLeft;

            this._typeLeft = this._left.GetType();
            return this._typeLeft;
        }
    }
}
