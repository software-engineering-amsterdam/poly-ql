using QSLib.Types;
using QSLib.Values;

namespace QSLib.Expressions.Unary
{
    class Not : Unary_Expression
    {
        #region Constructors
        public Not(QSExpression left, int lineNr)
            : base(left, lineNr)
        {
            base._operator = "!";
        }
#endregion

        #region TypeChecker
        public override void Check(TypeChecker checker)
        {
            checker.Check(this);
        }
        #endregion

        #region Getters
        public override QSType Type
        {
            get
            {
                return new BoolType();
            }
        }
        #endregion

        public override Value Evaluate()
        {
            this._value = this._internal.Evaluate().Not();
            this.OnPropertyChanged("GetValue");
            return this._value;
        }
    }
}
