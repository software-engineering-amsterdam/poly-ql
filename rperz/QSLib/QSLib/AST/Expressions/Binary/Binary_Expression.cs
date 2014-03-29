using QSLib.Types;
using QSLib.Values;
using QSLib.Visitors;
namespace QSLib.AST.Expressions
{
    public abstract class Binary_Expression : QSExpression
    {
        protected QSExpression _left;
        protected QSExpression _right;

        public Binary_Expression(int lineNr)
        {
            this._lineNr = lineNr;
        }

        public Binary_Expression(QSExpression a, QSExpression b, int lineNr)
        {
            this._left = a;
            this._right = b;
            this._lineNr = lineNr;
        }

        public override void Accept(IVisitor checker)
        {
            this._left.Accept(checker);
            this._right.Accept(checker);
            checker.Visit(this);
        }

        public QSType GetLeftType()
        {
            return this._left.Type;
        }

        public QSType GetRightType()
        {
            return this._right.Type;
        }

        public override abstract Value Evaluate();
        public abstract bool IsCompatible(QSType type);

        #region Object overrides
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            var comp = obj as Binary_Expression;
            return comp != null && this._left.Equals(comp._left) && this._right.Equals(comp._right);
        }

        public override string ToString()
        {
            return this._left.ToString() + this._operator + this._right.ToString();
        }
        #endregion
    }
}
