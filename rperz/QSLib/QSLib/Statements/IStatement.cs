using QSLib.Types;

namespace QSLib
{
    public interface IStatement
    {
        bool CheckType(TypeChecker checker);
        void CreateGUI(GUIBuilder guiBuilder);
    }
}
