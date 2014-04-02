using QSLib.AST.Types;
using QSLib.Visitors;
namespace QSLib.AST.Expressions.Literals
{
    public class QSInteger : Primary
    {
        private int _value;
        public QSInteger(int value, int lineNr)
            : base(lineNr)
        {
            this._value = value;
        }
        public override object Value
        {
            get { return this._value; }
        }
        public override QSType GetType(TypeMemory memory)
        {
            return new IntegerType();
        }

        public override T Accept<T>(IExpressionVisitor<T> checker)
        {
            return checker.Visit(this);
        }

    }
}
