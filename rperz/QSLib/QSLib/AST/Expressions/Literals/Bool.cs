using QSLib.AST.Types;
using QSLib.Visitors;
namespace QSLib.AST.Expressions.Literals
{
    public class QSBoolean : Primary 
    {
        private bool _value;
        public QSBoolean(bool value, int lineNr)
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
            return new BoolType();
        }
        public override T Accept<T>(IExpressionVisitor<T> checker)
        {
            return checker.Visit(this);
        }
    }


    
}
