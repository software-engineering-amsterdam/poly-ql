using System;
using System.Collections.Generic;
using QSLib.Expressions;
using QSLib.Expressions.Unary;
using QSLib.Types;
namespace QSLib
{
    public class TypeChecker
    {
        private List<String> _errorList = new List<String>();
        private List<Identifier> _identifiers = new List<Identifier>();
        private List<string> _questionLabels = new List<string>();
        private Form _form;
        private bool _result = false;

        private TypeChecker(Form f)
        {
            this._form = f;
        }

        public static TypeChecker CheckTypes(Form f)
        {
            TypeChecker checker = new TypeChecker(f);
            checker._form.Check(checker);
            return checker;
        }

        public void CheckLabel(string questionText, int lineNr)
        {
            if (this._questionLabels.Contains(questionText))
                this.ReportDuplicateLabel(questionText, lineNr);
            else
                this._questionLabels.Add(questionText);
        }

        internal void Check(Unary_Expression expression)
        {
            expression.CheckInternal(this);

            if (!expression.Type.IsCompatible(expression.GetInternalType()))
            {
                // type of unary is not compatible with it's expression
                this._result = false;
                this.ReportTypeMismatch(expression.GetInternalType(), expression.Operator, expression.Line);
            }
        }

        internal void Check(Binary_Expression expression)
        {
            expression.CheckLeft(this);
            expression.CheckRight(this);

            if (!(expression.GetLeftType().IsCompatible(expression.GetLeftType())))
            {
                this._result = false;
                this.ReportTypeMismatch(expression.GetLeftType(), expression.GetRightType(), expression.Operator, expression.Line);
            }

            if (!expression.GetLeftType().IsCompatible(expression.Type))
            {
                this.ReportTypeMismatch(expression.GetLeftType(), expression.Operator, expression.Line);
                this._result = false;
            }
        }

        internal void Check(Identifier id)
        {
            // the parent needs to be set, because it needs to know it's own value. Another way
            // would be to give each identifier the table with values, but this would
            // open up the opportunity to create an object that inherits Identifier and changes other identifiers values
            if (id.Type == null)
                id.Parent = this.TryGetValue(id, id.Line);
            else
                this.TryDeclare(id, id.Line);
            id.CheckInternal(this);
        }

        internal void Check(Question question)
        {
            this.CheckLabel(question.Text, question.Line);
            question.CheckIdentifier(this);
        }

        internal void Check(CodeBlock codeBlock)
        {
            codeBlock.CheckStatements(this);
        }

        internal void Check(Expressions.Literals.Primary primary)
        {
            // this type is always okay
        }

        internal void Check(QSExpression qSExpression)
        {
            qSExpression.Check(this);
        }

        public Identifier TryGetValue(Identifier identifier, int lineNr)
        {
            if (this._identifiers.Contains(identifier))
            {
                return this._identifiers.Find(id => id.Name.Equals(identifier.Name));
            }
            else
            {
                this.ReportUndeclared(identifier.Name, lineNr);
            }

            return null;
        }

        public void TryDeclare(Expressions.Unary.Identifier identifier, int lineNr)
        {
            if (this._identifiers.Contains(identifier))
            {
                this.ReportDuplicate(identifier.Name, lineNr);
                this._result = false;
            }
            else
            {
                this._identifiers.Add(identifier);
                this._result &= true;
            }
        }


        private void ReportParseError(int line)
        {
            this._errorList.Add("The type checker encountered an unexpected value; line number: " + line);
        }

        private void ReportDuplicateLabel(string questionText, int line)
        {
            this._errorList.Add("Warning: duplicate questiontext : " + questionText + "; line number: " + line);
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

        internal void Check(Form form)
        {
            form.CheckCode(this);
        }

        internal void Check(Statements.IfStatement ifStatement)
        {
            ifStatement.CheckCondition(this);

            if (!ifStatement.IsConditionBoolean())
            {
                this.ReportTypeMismatch(ifStatement.GetConditionType(), "if-statement", ifStatement.Line);
                this._result = false;
            }

            ifStatement.CheckCode(this);
            ifStatement.CheckElse(this);
        }
    }
}
