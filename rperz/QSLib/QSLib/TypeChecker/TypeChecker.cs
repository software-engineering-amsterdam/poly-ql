using System;
using System.Collections.Generic;
using QSLib.Types;
using QSLib.Expressions.Unary;
namespace QSLib
{
    public class TypeChecker
    {
        private List<String> _errorList = new List<String>();
        private List<Identifier> _identifiers = new List<Identifier>();
        private Form _form;
        private bool _result = false;

        private TypeChecker(Form f)
        {
            this._form = f;
        }

        public static TypeChecker CheckTypes(Form f)
        {
            TypeChecker checker = new TypeChecker(f);
            checker._result = checker._form.CheckType(checker);
            return checker;
        }

        public bool TryDeclare(Expressions.Unary.Identifier identifier, int lineNr)
        {
            if (this._identifiers.Contains(identifier))
            {
                this.ReportDuplicate(identifier.Name, lineNr);
                return false;
            }
            else
            {
                this._identifiers.Add(identifier);
                return true;
            }
        }

        public QSType TryGetType(Expressions.Unary.Identifier identifier, int lineNr)
        {
            if(this._identifiers.Contains(identifier))
            {
                return this._identifiers.Find(id => id.Name.Equals(identifier.Name)).Type;
            }
            else
            {
                this.ReportUndeclared(identifier.Name, lineNr);
                return null;
            }
        }

        public void ReportDuplicate(String name, int line)
        {
            this._errorList.Add("Duplicate declaration of " + name + "; line number: " + line);
        }

        public void ReportUndeclared(String name, int line)
        {
            this._errorList.Add("Variable " + name + " is used before being declared; line number: " + line);
        }

        public void ReportTypeMismatch(QSType t1, QSType t2, int line)
        {
            this._errorList.Add(t1.ToString() + " is not compatible with " + t2.ToString() +
                            "; line number: " + line);
        }

        public void ReportTypeMismatch(QSType t1, QSType t2, String op, int line)
        {
            this._errorList.Add("Operator " + op + " cannot be used with types " + t1.ToString() + " and " + 
                            t2.ToString() + "; line number: " + line);
        }

        public void ReportTypeMismatch(QSType t1, String op, int line)
        {
            this._errorList.Add("Operator " + op + " cannot be used with type " + t1.ToString() + 
                            "; line number: " + line);
        }

        public void ReportEmptyBlockWarning(string blocktype, int line)
        {
            this._errorList.Add("Warning: empty code block in " + blocktype + " block" +
                            "; line number: " + line);
        }

        public String GetCheckerOutput()
        {
            String retVal = "";
            foreach (String s in this._errorList)
            {
                retVal += s + "\r\n";
            }

            return retVal;
        }

        public bool Result 
        {
            get
            {
                return this._result;
            }
        }
    }
}
