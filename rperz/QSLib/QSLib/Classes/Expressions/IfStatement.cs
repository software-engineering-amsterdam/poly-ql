using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions.Conditions;

namespace QSLib.Expressions
{
    public class IfStatement : IStatement
    {
        private IExpression _condition;
        private CodeBlock _code;
        private ElseStatement _else;
        private int _linenr;

        public IfStatement(IExpression con, CodeBlock code, int linenr)
        {
            this._condition = con;
            this._code = code;
            this._linenr = linenr;
        }

        public ElseStatement SetElse
        {
            set
            {
                this._else = value;
            }
        }

        public override string ToString()
        {
            String retVal = "if(" + this._condition.ToString() + ") \r\n { \r\n" + this._code.ToString() + "\r\n }\r\n";
            if (this._else != null)
                retVal += this._else.ToString();
            return retVal ;
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
            bool retVal;
            if (this._else != null)
                retVal = this._condition.CheckType() && this._condition.Type.Equals(true.GetType()) && 
                            this._code.CheckType() && this._else.CheckType();
            else
                retVal = this._condition.CheckType() && this._condition.Type.Equals(true.GetType()) && 
                            this._code.CheckType();
            return retVal;
        }
    }
}
