using QSLib.Expressions.Literals;
using QSLib.Types;
using QSLib.Expressions.Unary;
namespace QSLib
{
    public class Question : IStatement
    {
        private Identifier _id;
        private QSString _text;
        private int _linenr;
        public Question(QSString text, Identifier id, int linenr)
        {
            this._text = text;
            this._id = id;
            this._linenr = linenr;
        }

        public override string ToString()
        {
            return this._text.ToString() + this._id.ToString();
        }

        public bool CheckType(TypeChecker checker)
        {
            return this._id.CheckType(checker);
        }

        public override bool Equals(object obj)
        {
            var comp = obj as Question;
            return comp != null && this._text.Equals(comp._text) && this._id.Equals(comp._id);
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public void CreateGUI(GUIBuilder guiBuilder)
        {
            guiBuilder.CreateQuestion((string)this._text.Evaluate().GetValue, this._id);
        }
    }

}
