using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions
{
    public class Unary_Expression : IExpression
    {
        protected IExpression _left;
        protected Type _typeLeft;

        public Unary_Expression(IExpression left)
        {
            this._left = left;
        }

        public Type CheckType()
        {
            if (this._typeLeft != null)
                return this._typeLeft;

            this._typeLeft = this._left.GetType();
            return this._typeLeft;
        }
    }
}
