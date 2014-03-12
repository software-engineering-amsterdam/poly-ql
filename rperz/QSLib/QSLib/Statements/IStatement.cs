using QSLib.Types;

namespace QSLib
{
    public interface IStatement
    {
        bool CheckType(TypeChecker checker);
        internal void CreateGUI(GUIBuilder guiBuilder);
    }
}
