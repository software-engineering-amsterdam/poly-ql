using QSLib.Types;
namespace QSLib.Expressions.Unary
{
    public abstract class Unary_Expression : QSExpression 
    {
        protected QSExpression _internal;

        #region Constructors
        public Unary_Expression(QSExpression intern, int lineNr)
        {
            this._internal = intern;
            this._lineNr = lineNr;
        }
        #endregion

        #region TypeChecker
        public override void Check(TypeChecker checker)
        {
            checker.Check(this);
        }

        internal virtual void CheckInternal(TypeChecker typeChecker)
        {
            this._internal.Check(typeChecker);
        }
        #endregion

        #region Object overrides
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            var comp = obj as Unary_Expression;
            return comp != null && (comp.Type == null || this.Type.IsCompatible(comp.Type)) && 
                ((this._internal == null && comp._internal == null) || this._internal.Equals(comp._internal));
        }

        public override string ToString()
        {
            return this._operator + this._internal.ToString();
        }
        #endregion

        internal QSType GetInternalType()
        {
            return this._internal.Type;
        }
    }
}
