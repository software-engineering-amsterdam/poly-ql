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
            else return "else {}";
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
            else if(this._code != null)
                return this._code.CheckType();
            else
                TypeChecker.ReportEmptyBlockWarning("else", this._linenr);
            return true;
        }

        public override bool Equals(object obj)
        {
            bool retVal = true;
            var comp = obj as ElseStatement;
            if (comp == null)
                return false;
            if (this._if != null && comp._if != null)
                retVal &= this._if.Equals(comp._if);
            else if (this._if != null || comp._if != null)
                retVal = false;
            if (this._code != null && comp._code != null)
                retVal &= this._code.Equals(comp._code);
            else if (this._code != null || comp._code != null)
                retVal = false;

            return retVal;
        }
    }
}
