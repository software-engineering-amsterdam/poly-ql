using QSLib.AST.Types;
using QSLib.Visitors;
using System;
namespace QSLib.AST.Expressions.Unary
{
    public abstract class Unary_Expression : QSExpression 
    {
        protected QSExpression _internal;

        #region Constructors
        public Unary_Expression(QSExpression intern, int lineNr)
            : base(lineNr)
        {
            this._internal = intern;
        }
        #endregion

        public override abstract T Accept<T>(IExpressionVisitor<T> checker);

        public abstract string GetOperator();

        public QSExpression Internal
        {
            get
            {
                return this._internal;
            }
        }

        internal QSType GetInternalType(TypeMemory memory)
        {
            return this._internal.GetType(memory);
        }
    }
}
