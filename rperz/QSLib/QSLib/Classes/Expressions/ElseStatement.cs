using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions
{
    public class ElseStatement : IStatement
    {
        private CodeBlock _code;
        private IfStatement _if;
        private int _linenr;

        public ElseStatement(int linenr)
        {
            this._linenr = linenr;
        }

        public ElseStatement(CodeBlock code, int linenr)
        {
            this._code = code;
            this._linenr = linenr;
        }

        public IfStatement SetIf
        {
            set
            {
                this._if = value;
            }
        }

        public override string ToString()
        {
            if (this._if != null)
                return "else " + this._if.ToString();
            if (this._code != null)
                return "else \r\n {" + this._code.ToString() + "\r\n}";
            else 
                throw new Exception("Syntax error on line ");
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
            if (this._if != null)
                return this._code.CheckType() && this._if.CheckType();
            else
                return this._code.CheckType();
        }
    }
}
