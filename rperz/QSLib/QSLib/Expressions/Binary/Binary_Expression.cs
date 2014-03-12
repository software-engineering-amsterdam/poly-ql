using System;
using QSLib.Types;

namespace QSLib.Expressions
{
    public abstract class Binary_Expression : IExpression
    {
        protected IExpression _left;
        protected IExpression _right;
        protected String _operator;
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

        public abstract QSType Type
        {
            get;
        }

        public bool CheckType(TypeChecker checker)
        {
            bool retVal = true;
            retVal &= this._left.CheckType(checker);
            retVal &= this._right.CheckType(checker);

            if (!(this._left.Type.IsCompatible(this._right.Type)))
            {
                retVal = false;
                checker.ReportTypeMismatch(this._left.Type, this._right.Type, this._operator, this._linenr);
            }

            if (!this._left.Type.IsCompatible(this.Type))
            {
                checker.ReportTypeMismatch(this._left.Type, this._operator, this._linenr);
                retVal = false;
            }

            return retVal;
        }

        public override bool Equals(object obj)
        {
            var comp = obj as Binary_Expression;
            return comp != null && this._left.Equals(comp._left) && this._right.Equals(comp._right);
        }

        public override string ToString()
        {
            return this._left.ToString() + this._operator + this._right.ToString();
        }
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }
}
