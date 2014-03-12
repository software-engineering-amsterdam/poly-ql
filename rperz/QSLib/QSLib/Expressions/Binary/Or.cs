using QSLib.Types;

namespace QSLib.Expressions.Binary
{
    class Or : Binary_Expression
    {
        public Or(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "||";
        }

        public bool GetBoolValue()
        {
            return this._left.GetBoolValue() && this._right.GetBoolValue(this._right);
        }

        public override QSType Type
        {
            get { return new BoolType(); }
        }
    }
}
