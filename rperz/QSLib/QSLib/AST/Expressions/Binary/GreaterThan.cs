using QSLib.AST.Types;
using QSLib.Visitors;
namespace QSLib.AST.Expressions.Binary
{
    public class GreaterThan : Binary_Expression
    {

        public GreaterThan(QSExpression a, QSExpression b, int lineNr)
            : base(a, b, lineNr)
        {
        }

        public override string GetOperator()
        {
            return ">";
        }

        public override T Accept<T>(IExpressionVisitor<T> checker)
        {
            return checker.Visit(this);
        }

        public override QSType GetType(TypeMemory memory)
        {
            return new BoolType();
        }

        public override bool IsCompatible(QSType type)
        {
            return type.IsInteger();
        }
    }
}
