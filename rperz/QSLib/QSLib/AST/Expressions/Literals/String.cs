using System;
using QSLib.AST.Types;
using QSLib.Visitors;
namespace QSLib.AST.Expressions.Literals
{
    public class QSString : Primary
    {
        private string _value;
        public QSString(String value, int lineNr)
            : base(lineNr)
        {
            this._value = value;
        }

        public override T Accept<T>(IExpressionVisitor<T> checker)
        {
            return checker.Visit(this);
        }

        public override object Value
        {
            get { return this._value; }
        }
        public override QSType GetType(TypeMemory memory)
        {
            return new StringType();
        }
    }
}
