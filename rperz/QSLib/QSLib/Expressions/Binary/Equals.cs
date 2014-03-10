using QSLib.Types;
namespace QSLib.Expressions.Binary
{
    class Equals : Binary_Expression
    {
        public Equals(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "==";
        }


        public override QSType Type
        {
            get { return new BoolType(); }
        }
    }
}
