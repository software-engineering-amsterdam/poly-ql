using QSLib.Types;

namespace QSLib.Expressions.Unary
{
    public abstract class Unary_Expression : IExpression 
    {
        protected int _linenr;
        protected string _operator;
        protected IExpression _expr;
        protected QSType _type;

        public Unary_Expression(IExpression expr, int linenr)
        {
            this._expr = expr;
            this._linenr = linenr;
        }

        public override string ToString()
        {
            return this._operator + this._expr.ToString();
        }

        public virtual bool CheckType(TypeChecker checker)
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

        public abstract QSType Type
        {
            get;
        }

        public override bool Equals(object obj)
        {
            var comp = obj as Unary_Expression;
            return comp != null && this.Type.IsCompatible(comp.Type) && ((this._expr == null && comp._expr == null) || this._expr.Equals(comp._expr));
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

    }
}
