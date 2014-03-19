using QL.QLClasses.Types;
using QL.QLClasses.Values;

namespace QL.QLClasses.Expressions
{
    public abstract class ExpressionBase : ASTBase
    {
        public abstract QType GetResultType();
        public abstract QValue Evaluate();
    }
}
