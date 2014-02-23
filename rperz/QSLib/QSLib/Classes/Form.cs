using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions;

namespace QSLib
{
    public class Form
    {
        private CodeBlock _code;
        public Form(CodeBlock code)
        {
            this._code = code;
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
            return this._code.CheckType();
        }

    }
}
