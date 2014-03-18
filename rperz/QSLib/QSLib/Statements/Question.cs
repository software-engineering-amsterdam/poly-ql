using QSLib.Expressions.Literals;
using QSLib.Expressions.Unary;
namespace QSLib
{
    public class Question : IStatement
    {
        private Identifier _id;
        private QSString _text;
        private int _lineNr;

        #region Constructors
        public Question(QSString text, Identifier id, int lineNr)
        {
            this._text = text;
            this._id = id;
            this._lineNr = lineNr;
        }
        #endregion

        #region Getters
        public string Text
        {
            get
            {
                return this._text.ToString();
            }
        }

        public int Line
        {
            get
            {
                return this._lineNr;
            }
        }
        #endregion

        #region TypeChecker
        public void Check(TypeChecker checker)
        {
            checker.Check(this);
        }

        public void CheckIdentifier(TypeChecker checker)
        {
            this._id.Check(checker);
        }
        #endregion

        #region Object overrides
        public override bool Equals(object obj)
        {
            var comp = obj as Question;
            return comp != null && this._text.Equals(comp._text) && this._id.Equals(comp._id);
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override string ToString()
        {
            return this._text.ToString() + this._id.ToString();
        }
        #endregion

        public void CreateGUI(GUIBuilder guiBuilder)
        {
            guiBuilder.CreateQuestion((string)this._text.Evaluate().GetValue, this._id);
        }
    }

}
