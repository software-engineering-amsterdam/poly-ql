using QSLib.Types;
using QSLib.Visitors;
namespace QSLib.AST.Statements
{
    public interface IStatement
    {
        void Accept(IVisitor checker);
        void CreateGUI(GUIBuilder guiBuilder);
    }
}
