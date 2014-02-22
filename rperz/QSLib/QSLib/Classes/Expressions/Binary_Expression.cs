using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Errors;
namespace QSLib.Expressions
{
    public abstract class Binary_Expression : IExpression
    {
        protected  IExpression _left;
        protected  IExpression _right;
        protected  Type _type;
        protected  Type _typeLeft;
        protected Type _typeRight;
        protected String _operator = "Empty";

        public Binary_Expression()
        {
        }

        public Binary_Expression(IExpression a, IExpression b)
        {
            this._left = a;
            this._right = b;
        }

        public Type CheckType()
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

        public override string ToString()
        {
            return this._left.ToString() + this._operator + this._right.ToString();
        }
    }
}
