using QSLib.AST.Types;
using QSLib.Visitors;
namespace QSLib.AST.Expressions.Binary
{
    public class Multiply : Binary_Expression 
    {
        public Multiply(QSExpression a, QSExpression b, int lineNr)
            : base(a, b, lineNr)
        {
        }

        public override string GetOperator()
        {
            return "*";
        }

        public override QSType GetType(TypeMemory memory)
        {
            return new IntegerType();
        }

        public override T Accept<T>(IExpressionVisitor<T> checker)
        {
            return checker.Visit(this);
        }

        public override bool IsCompatible(QSType type)
        {
            return type.IsInteger();
        }
    }
}
