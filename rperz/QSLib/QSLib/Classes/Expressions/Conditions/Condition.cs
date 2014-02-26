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
            if (this._left != null)
                retVal &= this._left.CheckType();
            if (this._right != null)
                retVal &= this._right.CheckType();

            if (this._right != null && this._left != null && !(this._left.Type.Equals(this._right.Type)))
            {
                // operands not of same type
                retVal = false;
                TypeChecker.ReportTypeMismatch(this._left.Type, this._right.Type, this._operator, this._linenr);
            }
            else if (!retVal && this._right != null && this._right.Type != true.GetType())
            {
                // type of unary condition is not boolean
                retVal = false;
                TypeChecker.ReportTypeMismatch(this._left.Type, this._operator, this._linenr);
            }

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
                    // this is a binary condition
                    this._typeRight = this._right.Type;
                    this._typeLeft = this._left.Type;

                    // if the types do not match, the type error is handled by CheckType
                    return this._typeLeft;
                }
                else
                {
                    // this is a unary condition
                    if (this._typeLeft != null)
                    {
                        this._type = this._typeLeft;
                        return this._typeLeft;
                    }

                    this._typeLeft = this._left.Type;
                    this._type = this._typeLeft;
                    return this._typeLeft;
                }
            }
        }

        public override bool Equals(object obj)
        {
            bool retVal = true;
            var comp = obj as Condition;
            if (comp == null)
                return false;

            // check if both have a left operand set and check if these are equal (else if only one has one it is false)
            if (this._left != null && comp._left != null)
                retVal &= this._left.Equals(comp._left);
            else if (this._left != null || comp._left != null)
                retVal = false;

            // check if both have a right operand set and check if these are equal (else if only one has one it is false)
            if (this._right != null && comp._right != null)
                retVal &= this._right.Equals(comp._right);
            else if (this._right != null || comp._right != null)
                retVal = false;
            
            return retVal;
        }

    }
}
