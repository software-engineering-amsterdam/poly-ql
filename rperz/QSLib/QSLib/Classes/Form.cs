using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions;
using QSLib.Expressions.Types;

namespace QSLib
{
    public class Form
    {
        private CodeBlock _code;
        private int _linenr;

        public Form(CodeBlock code, int linenr)
        {
            Identifier.ClearIdentifiers();
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
        public bool CheckType()
        {
            if(this._code != null)
                return this._code.CheckType();
            TypeChecker.ReportEmptyBlockWarning("form", this._linenr);
            return true;
        }

        public override bool Equals(object obj)
        {
            bool retVal = true;
            var comp = obj as Form;
            if (comp == null)
                return false;
            retVal &= this._code.Equals(comp._code);
            return retVal ;
        } 

    }
}
