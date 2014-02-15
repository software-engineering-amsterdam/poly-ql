using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Errors;
namespace QSLib.Expressions
{
    public class Binary_Expression : Expression
    {
        protected  Expression _left;
        protected  Expression _right;
        protected  Type _type;
        protected  Type _typeLeft;
        protected  Type _typeRight;

        public  override Type GetType()
        {
            if (this._type != null)
                return this._type;

            this._typeRight = this._right.GetType();
            this._typeLeft = this._left.GetType();

            // if the types do not match, we have a type error
            if (this._typeLeft.Equals(this._typeRight))
                return this._typeLeft;
            else
                throw new TypeException("Type error: " + this._typeLeft.ToString() + 
                                        " is incompatible with " + this._typeRight.ToString());
        }
    }
}
