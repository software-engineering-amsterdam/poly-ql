using System;
using QSLib.Expressions.Literals;
using QSLib.Expressions.Unary;

namespace QSLib
{
    public class Form
    {
        private CodeBlock _code;
        private int _linenr;

        public Form(CodeBlock code, int linenr)
        {
            this._code = code;
            this._linenr = linenr;
        }

        public override string ToString()
        {
            return "form \r\n { \r\n" + this._code.ToString() + "\r\n }";
        }

        public Type Type
        {
            get
            {
                return null;
            }
        }
        public bool CheckType(TypeChecker checker)
        {
            if(this._code != null)
                return this._code.CheckType(checker);
            checker.ReportEmptyBlockWarning("form", this._linenr);
            return true;
        }

        public override bool Equals(object obj)
        {
            var comp = obj as Form;
            return comp != null && this._code.Equals(comp._code);
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

    }
}
