using QSLib.Types;
namespace QSLib.Expressions.Binary
{
    public class Add : Binary_Expression  
    {
        public Add(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "+";
        }

        public override QSType Type
        {
            get { return new NumberType(); }
        }
    }
}
