using QSLib.AST.Types;
using System.ComponentModel;
using QSLib.Visitors;

namespace QSLib.AST.Expressions
{
    public abstract class QSExpression 
    {
        private int _lineNr;

        public QSExpression(int lineNr)
        {
            this._lineNr = lineNr;
        }
        public abstract T Accept<T>(IExpressionVisitor<T> checker);

        public abstract QSType GetType(TypeMemory memory);

        public int Line
        {
            get
            {
                return this._lineNr;
            }
        }
    }
}
