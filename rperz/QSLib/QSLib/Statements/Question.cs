using QSLib.Expressions.Literals;
using QSLib.Types;
using QSLib.Expressions.Unary;
namespace QSLib
{
    public class Question : IStatement
    {
        private Identifier _name;
        private QSString _text;
        private int _linenr;
        public Question(QSString text, Identifier name, int linenr)
        {
            this._text = text;
            this._name = name;
            this._linenr = linenr;
        }

        public override string ToString()
        {
            return this._text.ToString() + this._name.ToString();
        }

        public string QuestionLabel
        {
            get
            {
                return this._text.GetValue();
            }
        }
        public bool CheckType(TypeChecker checker)
        {
            return this._name.CheckType(checker);
        }

        public override bool Equals(object obj)
        {
            var comp = obj as Question;
            return comp != null && this._text.Equals(comp._text) && this._name.Equals(comp._name);
        }
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }


    }

}
