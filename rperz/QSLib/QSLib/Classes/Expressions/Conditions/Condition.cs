using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Errors;
namespace QSLib.Expressions.Conditions
{
    public abstract class Condition : IExpression
    {
        protected IExpression _left;
        protected IExpression _right;
        protected Type _type;
        protected Type _typeLeft;
        protected Type _typeRight;
        protected String _operator = "Empty";
        protected int _linenr;
        public Condition(int linenr)
        {
            this._linenr = linenr;
        }

        public Condition(IExpression left, int linenr)
        {
            this._left = left;
            this._linenr = linenr;
        }

        public Condition(IExpression a, IExpression b, int linenr)
        {
            this._left = a;
            this._right = b;
            this._linenr = linenr;
        }



        public override string ToString()
        {
            if (this._right != null)
                return this._left.ToString() + " " + this._operator + " " + this._right.ToString();
            else
                return this._operator + this._left.ToString() ;
        }

        public virtual bool CheckType()
        {
            bool retVal = true;
            if(this._left != null)
                retVal &= this._left.CheckType();
            if (this._right != null)
                retVal &= this._right.CheckType();

            if (this._left != null && this._right != null)
                retVal &= (this._left.Type.Equals(this._right.Type));
            return retVal;
        }

        public Type Type
        {
            get
            {
                if (this._type != null)
                    return this._type;
                if (this._right != null)
                {
                    this._typeRight = this._right.GetType();
                    this._typeLeft = this._left.GetType();

                    // if the types do not match, we have a type error
                    if (this._typeLeft.Equals(this._typeRight))
                        return this._typeLeft;
                    else
                        throw new TypeException("Type error: " + this._typeLeft.ToString() +
                                                " is incompatible with " + this._typeRight.ToString());
                }
                else
                {
                    if (this._typeLeft != null)
                    {
                        this._type = this._typeLeft;
                        return this._typeLeft;
                    }


                    this._typeLeft = this._left.GetType();
                    this._type = this._typeLeft;
                    return this._typeLeft;
                }
            }
        }

    }
}
