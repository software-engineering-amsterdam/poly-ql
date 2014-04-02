using QSLib.AST.Types;
using QSLib.Visitors;
using System;
namespace QSLib.AST.Expressions
{
    public abstract class Binary_Expression : QSExpression
    {
        protected QSExpression _left;
        protected QSExpression _right;

        public Binary_Expression(int lineNr)
            : base(lineNr)
        {
        }

        public Binary_Expression(QSExpression a, QSExpression b, int lineNr)
            : base(lineNr)
        {
            this._left = a;
            this._right = b;
        }

        public abstract override T Accept<T>(IExpressionVisitor<T> checker);
        public abstract override QSType GetType(TypeMemory memory);


        public QSType GetLeftType(TypeMemory memory)
        {
            return this._left.GetType(memory);
        }

        public QSType GetRightType(TypeMemory memory)
        {
            return this._right.GetType(memory);
        }

        public QSExpression Left
        {
            get
            {
                    return this._left;
            }
        }

        public QSExpression Right
        {
            get
            {
                return this._right;
            }
        }

        public abstract string GetOperator();
        public abstract bool IsCompatible(QSType type);

    }
}
