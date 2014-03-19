using QSLib.Types;
using QSLib.Values;
using QSLib.Visitors;
namespace QSLib.AST.Expressions.Unary
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
        public override void Accept(IVisitor checker)
        {
            checker.Visit(this);
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
