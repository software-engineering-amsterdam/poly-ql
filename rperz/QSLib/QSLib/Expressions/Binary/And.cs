using QSLib.Types;
namespace QSLib.Expressions.Binary
{
    class And : Binary_Expression
    {
        public And(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "&&";
        }

        public object GetValue()
        {
            return (bool)this._left.GetValue() && (bool)this._right.GetValue();
        }

        public override QSType Type
        {
            get { return new BoolType(); }
        }
    }
}
