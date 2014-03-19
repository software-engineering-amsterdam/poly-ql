using System;
using QSLib.Visitors;

namespace QSLib.AST
{
    public class Form
    {
        private CodeBlock _code;
        private int _lineNr;

        #region Constructors
        public Form(CodeBlock code, int lineNr)
        {
            this._code = code;
            this._lineNr = lineNr;
        }
        #endregion

        #region Getters
        public Type Type
        {
            get
            {
                return null;
            }
        }
        #endregion

        #region TypeChecker
        public void Accept(IVisitor checker)
        {
            checker.Visit(this);
            this._code.Accept(checker);
        }
        #endregion

        #region Object overrides
        public override bool Equals(object obj)
        {
            var comp = obj as Form;
            return comp != null && this._code.Equals(comp._code);
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override string ToString()
        {
            return "form \r\n { \r\n" + this._code.ToString() + "\r\n }";
        }
        #endregion

        internal void CreateGUI(GUIBuilder guiBuilder)
        {
            this._code.CreateGUI(guiBuilder);
        }
    }
}
