using QSLib.Types;
namespace QSLib.Expressions.Binary
{
    public class Multiply : Binary_Expression 
    {
        public Multiply(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "*";
        }

        public override QSType Type
        {
            get { return new NumberType(); }
        }
    }
}
