using QSLib.AST.Types;
using QSLib.Visitors;
namespace QSLib.AST.Expressions.Literals
{
    public abstract class Primary : QSExpression
    {
        public Primary(int lineNr)
            : base(lineNr)
        {
        }

        public abstract object Value { get; }

        public abstract override T Accept<T>(IExpressionVisitor<T> checker);
        public abstract override QSType GetType(TypeMemory memory);

    }
}
