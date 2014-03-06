using QL.QLClasses.Types;

namespace QL.QLClasses.Expressions
{
    public abstract class ExpressionBase : ASTBase
    {
        public abstract QBaseType GetResultType();
        public abstract ExpressionBase GetResult();
    }
}
