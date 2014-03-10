using QSLib.Types;

namespace QSLib.Expressions.Binary
{
    class SmallerThan_Equals : Binary_Expression
    {
        public SmallerThan_Equals(IExpression a, IExpression b, int linenr)
            : base(a, b, linenr)
        {
            base._operator = "<=";
        }

        public override QSType Type
        {
            get { return new BoolType(); }
        }
    }
}
