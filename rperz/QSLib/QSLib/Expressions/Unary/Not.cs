using QSLib.Types;
namespace QSLib.Expressions.Unary
{
    class Not : Unary_Expression
    {

        public Not(IExpression left, int linenr)
            : base(left, linenr)
        {
            base._operator = "!";
        }

        public override bool CheckType(TypeChecker checker)
        {
            bool retVal = base.CheckType(checker);
            if (!this._expr.Type.IsBoolean())
                checker.ReportTypeMismatch(this._expr.Type, this._operator, this._linenr);
            
            return retVal;
        }

        public override QSType Type
        {
            get
            {
                return new BoolType();
            }
        }
    }
}
