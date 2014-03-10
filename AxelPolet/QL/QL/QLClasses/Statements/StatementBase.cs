using QL.Interpreter;
using QL.Interpreter.Controls;

namespace QL.QLClasses.Statements
{
    public abstract class StatementBase : ASTBase, IBuilder
    {
        public abstract void Build(GUIQuestionnaire gui);
    }
}
