using QSLib.Types;
using QSLib.Expressions.Values;
using System;
using System.ComponentModel;
namespace QSLib.Expressions.Unary
{
    public abstract class Unary_Expression : QSExpression 
    {

        protected string _operator;
        protected QSExpression _expr;

        public Unary_Expression(QSExpression expr, int linenr)
        {
            this._expr = expr;
            this._linenr = linenr;
        }

        public override string ToString()
        {
            return this._operator + this._expr.ToString();
        }

        public override bool CheckType(TypeChecker checker)
        {
            bool retVal = true;

            retVal &= (this._expr == null || this._expr.CheckType(checker));

            if (this._expr != null && !this.Type.IsCompatible(this._expr.Type))
            {
                // type of unary is not compatible with it's expression
                retVal = false;
                checker.ReportTypeMismatch(this._expr.Type, this._operator, this._linenr);
            }

            return retVal;
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            var comp = obj as Unary_Expression;
            return comp != null && this.Type.IsCompatible(comp.Type) && ((this._expr == null && comp._expr == null) || this._expr.Equals(comp._expr));
        }

    }
}
