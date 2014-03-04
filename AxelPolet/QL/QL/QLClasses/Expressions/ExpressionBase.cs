using Antlr4.Runtime;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions
{
    public abstract class ExpressionBase : ASTBase
    {
        public abstract QBaseType GetResultType();
        public abstract ExpressionBase GetResult();
    }
}
