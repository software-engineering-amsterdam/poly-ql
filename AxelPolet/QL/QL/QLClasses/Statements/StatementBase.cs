using QL.Interpreter;

namespace QL.QLClasses.Statements
{
    public abstract class StatementBase : ASTBase, IBuilder
    {
        public abstract void Build(QLGuiBuilder guiBuilder);
    }
}
