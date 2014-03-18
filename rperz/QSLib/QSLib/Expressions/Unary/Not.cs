using QSLib.Types;
using QSLib.Values;
using System.ComponentModel;

namespace QSLib.Expressions.Unary
{
    class Not : Unary_Expression
    {


        public Not(QSExpression left, int linenr)
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


        public override Value Evaluate()
        {
            this._value = this._expr.Evaluate().Not();
            this.OnPropertyChanged("GetValue");
            return this._value;
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
