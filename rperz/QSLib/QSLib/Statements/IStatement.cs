using QSLib.Types;

namespace QSLib
{
    public interface IStatement
    {
        void Check(TypeChecker checker);
        void CreateGUI(GUIBuilder guiBuilder);
    }
}
