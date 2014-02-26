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
            bool retVal = true;

            retVal &= this._condition.CheckType();
           
            if (!this._condition.Type.Equals(true.GetType()))
            {
                TypeChecker.ReportTypeMismatch(this._condition.Type, "if-statement", this._linenr);
                retVal = false;
            }
            if(this._else != null)
                retVal &= this._else.CheckType();
            if(this._code != null)
                retVal &= this._code.CheckType();
            else
                TypeChecker.ReportEmptyBlockWarning("if", this._linenr);

            return retVal;
        }

        public override bool Equals(object obj)
        {
            bool retVal = true;
            var comp = obj as IfStatement;
            if (comp == null)
                return false;

            // check if both have a condition set and check if these are equal (else if only one has one it is false)
            if (this._condition != null && comp._condition != null)
                retVal &= this._condition.Equals(comp._condition);
            else if (this._condition != null || comp._condition != null)
                retVal = false;

            // check if both have a codeblock set and check if these are equal (else if only one has one it is false)
            if (this._code != null && comp._code != null)
                retVal &= this._code.Equals(comp._code);
            else if (this._code != null || comp._code != null)
                retVal = false;

            // check if both have a else set and check if these are equal (else if only one has one it is false)
            if (this._else != null && comp._else != null)
                retVal &= this._else.Equals(comp._else);
            else if (this._else != null || comp._else != null)
                retVal = false;
            return retVal;
        }
    }
}
