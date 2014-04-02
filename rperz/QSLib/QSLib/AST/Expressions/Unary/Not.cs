using QSLib.AST.Types;
using QSLib.Visitors;
namespace QSLib.AST.Expressions.Unary
{
    public class Not : Unary_Expression
    {

        public Not(QSExpression left, int lineNr)
            : base(left, lineNr)
        {

        }


        #region TypeChecker
        public override T Accept<T>(IExpressionVisitor<T> checker)
        {
            return checker.Visit(this);
        }
        #endregion

        #region Getters
        public override string GetOperator()
        {
            return "!";
        }

        public override QSType GetType(TypeMemory memory)
        {
            return new BoolType();
        }

        #endregion

    }
}
