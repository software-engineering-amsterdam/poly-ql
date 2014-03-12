using QSLib.Types;
namespace QSLib.Expressions.Binary
{
    public class Divide : Binary_Expression 
    {
        public Divide(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "/";
        }

        public object GetValue()
        {
            return (int)this._left.GetValue() / (int)this._right.GetValue();
        }

        public override QSType Type
        {
            get { return new NumberType(); }
        }
    }
}
