using System;
using System.Collections.Generic;
using QSLib.AST.Expressions;
using QSLib.AST;
using QSLib.AST.Expressions.Unary;
using QSLib.AST.Expressions.Unary.Identifiers;
using QSLib.Types;
using QSLib.AST.Expressions.Literals;
using QSLib.AST.Statements;
using QSLib.Error;
namespace QSLib.Visitors
{
    public class TypeChecker : IVisitor
    {
        private ErrorCollection _errorList = new ErrorCollection();
        private List<Identifier> _identifiers = new List<Identifier>();
        private List<string> _questionLabels = new List<string>();
        private Form _form;
        private bool _result = true;

        private TypeChecker(Form f)
        {
            this._form = f;
        }

        public static IVisitor StartVisit(Form questionaire)
        {
            TypeChecker checker = new TypeChecker(questionaire);
            checker._form.Accept(checker);
            return checker;
        }

        public void CheckLabel(string questionText, int lineNr)
        {
            if (this._questionLabels.Contains(questionText))
                this._errorList.Add(new DuplicateLabelWarning(questionText, lineNr));
            else
                this._questionLabels.Add(questionText);
        }

        public void Visit(Unary_Expression expression)
        {
            if (!expression.Type.IsCompatible(expression.GetInternalType()))
            {
                // type of unary is not compatible with it's expression
                this._result = false;
                this._errorList.Add(new UnaryOperatorTypeMismatch(expression.GetInternalType(), expression.Operator, expression.Line));
            }
        }

        public void Visit(Binary_Expression expression)
        {
            if (!(expression.GetLeftType().IsCompatible(expression.GetLeftType())))
            {
                this._result = false;
                this._errorList.Add(new OperatorTypeMismatch(expression.GetLeftType(), expression.GetRightType(), expression.Operator, expression.Line));
            }

            if (!expression.GetLeftType().IsCompatible(expression.Type))
            {
                this._errorList.Add(new UnaryOperatorTypeMismatch(expression.GetLeftType(), expression.Operator, expression.Line));
                this._result = false;
            }
        }

        public void Visit(Identifier id)
        {
            if (id.Type == null)
                id.Parent = this.TryGetValue(id, id.Line);
            else
                this.TryDeclare(id, id.Line);
        }

        public void Visit(OutputIdentifier id)
        {
            if (id.Type == null)
                id.Parent = this.TryGetValue(id, id.Line);
            else
                this.TryDeclare(id, id.Line);

            if (!id.Type.IsCompatible(id.GetInternalType()))
            {
                this._errorList.Add(new TypeMismatchError(id.Type, id.GetInternalType(), id.Line));
                this._result = false;
            }
        }

        public void Visit(Question question)
        {
            this.CheckLabel(question.Text, question.Line);
        }

        public void Visit(CodeBlock codeBlock)
        {
            // do nothing as codeblock has no type checking (only the internal statements)
        }

        public void Visit(Primary primary)
        {
            // this type is always okay
        }

        public Identifier TryGetValue(Identifier identifier, int lineNr)
        {
            if (this._identifiers.Contains(identifier))
            {
                return this._identifiers.Find(id => id.Name.Equals(identifier.Name));
            }
            else
            {
                this._result = false;
                this._errorList.Add(new UndeclaredVariableError(identifier.Name, lineNr));
            }

            return null;
        }

        public void TryDeclare(Identifier identifier, int lineNr)
        {
            if (this._identifiers.Contains(identifier))
            {
                this._errorList.Add(new DuplicateDeclarationError(identifier.Name, lineNr));
                this._result = false;
            }
            else
            {
                this._identifiers.Add(identifier);
                this._result &= true;
            }
        }

        public object Output
        {
            get
            {
                return this._errorList;
            }
        }

        public string GetStringOutput()
        {
            String retVal = "";
            if (this._errorList.Count == 0)
                return "No problems found during type checking!";
            foreach (QSError error in this._errorList)
            {
                retVal += error.ToString() + "\r\n";
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

        public void Visit(Form form)
        {
            // do nothing, as the codeblock check is called from the visit method
        }

        public void Visit(IfStatement ifStatement)
        {
            if (!ifStatement.IsConditionBoolean())
            {
                this._errorList.Add(new UnaryOperatorTypeMismatch(ifStatement.GetConditionType(), "if-statement", ifStatement.Line));
                this._result = false;
            }
        }
    }
}
