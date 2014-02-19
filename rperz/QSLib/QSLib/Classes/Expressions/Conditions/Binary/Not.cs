using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions.Types;
using QSLib.Errors;
namespace QSLib.Expressions.Conditions.Binary
{
    class Not : Unary_Expression
    {

        public override Type GetType()
        {
            this._typeLeft = this._left.GetType();
            if(this._typeLeft.Equals(new Bool().GetType()))
                return this._typeLeft;
            else
                throw new TypeException("Type error: ! operator can not handle type " + 
                                        this._typeLeft.ToString());
        }
    }
}
