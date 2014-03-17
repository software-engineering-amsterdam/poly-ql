using System;
using QSLib.Types;
using QSLib.Expressions.Values;
using System.ComponentModel;

namespace QSLib.Expressions
{
    public abstract class Binary_Expression : QSExpression
    {
        protected QSExpression _left;
        protected QSExpression _right;
        protected String _operator;

        public Binary_Expression(int linenr)
        {
            this._linenr = linenr;
        }

        public Binary_Expression(QSExpression a, QSExpression b, int linenr)
        {
            this._left = a;
            this._right = b;
            this._linenr = linenr;
        }

        public override bool CheckType(TypeChecker checker)
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

        public override abstract Value Evaluate();

        public override int GetHashCode()
        {
            return base.GetHashCode();
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


    }
}
