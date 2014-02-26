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
        protected int _linenr;

        public Binary_Expression(int linenr)
        {
            this._linenr = linenr;
        }

        public Binary_Expression(IExpression a, IExpression b, int linenr)
        {
            this._left = a;
            this._right = b;
            this._linenr = linenr;
        }

        public Type Type
        {
            get
            {
                if (this._type != null)
                    return this._type;

                this._typeRight = this._right.Type;
                this._typeLeft = this._left.Type;

                // if the types do not match, it will be caught by the CheckType function
                return this._typeLeft;
            }
        }

        public bool CheckType()
        {
            bool retVal = true;
            if(this._left != null)
                retVal &= this._left.CheckType();
            if(this._right != null)
                retVal &= this._right.CheckType();

            if (this._right != null && this._left != null && !(this._left.Type.Equals(this._right.Type)))
            {
                retVal = false;
                TypeChecker.ReportTypeMismatch(this._left.Type, this._right.Type, this._operator, this._linenr);
            }

            return retVal;
        }

        public override bool Equals(object obj)
        {
            bool retVal = true;
            var comp = obj as Binary_Expression;
            if (comp == null)
                return false;
            if (this._left != null && comp._left != null)
                retVal &= this._left.Equals(comp._left);
            else if (this._left != null || comp._left != null)
                retVal = false;
            if (this._right != null && comp._right != null)
                retVal &= this._right.Equals(comp._right);
            else if (this._right != null || comp._right != null)
                retVal = false;

            return retVal;
        }

        public override string ToString()
        {
            return this._left.ToString() + this._operator + this._right.ToString();
        }
    }
}
