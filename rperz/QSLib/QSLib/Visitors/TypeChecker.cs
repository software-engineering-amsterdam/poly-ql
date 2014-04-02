using System;
using System.Collections.Generic;
using QSLib.AST.Expressions;
using QSLib.AST;
using QSLib.AST.Expressions.Unary;
using QSLib.AST.Expressions.Nullary;
using QSLib.AST.Types;
using QSLib.AST.Expressions.Literals;
using QSLib.AST.Statements;
using QSLib.Error;
namespace QSLib.Visitors
{
    public class TypeChecker : IVisitor<bool>
    {
        private ErrorCollection _errorList = new ErrorCollection();
        private TypeMemory _typeMem = new TypeMemory();
        private List<string> _questionLabels = new List<string>();
        private Form _form;
        private bool _result = true;

        private TypeChecker(Form f)
        {
            
            this._form = f;
        }

        public static IVisitor<bool> StartVisit(Form questionaire)
        {
            TypeChecker checker = new TypeChecker(questionaire);
            checker._result = checker._form.Accept<bool>(checker);
            return checker;
        }

        public bool CheckLabel(string questionText, int lineNr)
        {
            if (this._questionLabels.Contains(questionText))
            {
                this._errorList.Add(new DuplicateLabelWarning(questionText, lineNr));
                return false;
            }
            else
            {
                this._questionLabels.Add(questionText);
                return true;
            }
        }

        public bool Visit(Unary_Expression expression)
        {
            bool result = expression.Internal.Accept<bool>(this);
            QSType operatorType = expression.GetType(this._typeMem);
            QSType internalType = expression.GetInternalType(this._typeMem);
            if (!operatorType.IsCompatible(internalType))
            {
                // type of unary is not compatible with it's expression
                result = false;
                this._errorList.Add(new UnaryOperatorTypeMismatch(internalType, expression.GetOperator(), expression.Line));
            }
            return result;
        }

        public bool Visit(Binary_Expression expression)
        {
            bool result = true;
            result &= expression.Left.Accept<bool>(this);
            result &= expression.Right.Accept<bool>(this);
            QSType exprType = expression.GetType(this._typeMem);
            QSType leftType = expression.GetLeftType(this._typeMem);
            QSType rightType = expression.GetRightType(this._typeMem);
            if (!leftType.IsCompatible(rightType))
            {
                this._errorList.Add(new OperatorTypeMismatch(leftType, rightType, expression.GetOperator(),
                                                            expression.Line));
                result = false;
            }

            if (!leftType.IsCompatible(exprType))
            {
                this._errorList.Add(new TypeMismatchError(leftType, rightType, expression.Line));
                result = false;
            }
            return result;
        }

        public bool Visit(Identifier id)
        {
            return this._typeMem.IsDeclared(id.Name);
        }

        public bool Visit(Question question)
        {
            this.CheckLabel(question.Text, question.Line);
            return this.TryDeclare(question.Id, question.Type, question.Line);        
        }

        public bool Visit(ComputedQuestion computedQuestion)
        {
            bool result = true;
            result &= this.TryDeclare(computedQuestion.Id, computedQuestion.Type, computedQuestion.Line);
            result &= computedQuestion.Expression.Accept<bool>(this);
            if (!computedQuestion.Type.IsCompatible(computedQuestion.Expression.GetType(this._typeMem)))
            {
                this._errorList.Add(new TypeMismatchError(computedQuestion.Type,
                                    computedQuestion.Expression.GetType(this._typeMem), computedQuestion.Line));
                result = false;
            }
            return result;
        }

        public bool Visit(CodeBlock codeBlock)
        {
            bool result = true;
            if (codeBlock.Statements.Count > 0)
            {
                foreach(IStatement stat in codeBlock.Statements)
                {
                    result &= stat.Accept<bool>(this);
                }
            }
            return result;
        }

        public bool Visit(Primary primary)
        {
            return true;
        }

        public bool TryDeclare(string identifier, QSType type, int lineNr)
        {
            bool isDeclared = this._typeMem.TryDeclare(identifier, type);
            if (!isDeclared)
            {
                this._errorList.Add(new DuplicateDeclarationError(identifier, lineNr));
                return false;
            }
            return isDeclared;
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

        public bool Visit(Form form)
        {
            return form.Code.Accept<bool>(this);
        }

        public bool Visit(IfStatement ifStatement)
        {
            bool result = true;
            result &= ifStatement.Condition.Accept<bool>(this);
            if (!ifStatement.GetConditionType(this._typeMem).IsBoolean())
            {
                this._errorList.Add(new UnaryOperatorTypeMismatch(ifStatement.GetConditionType(this._typeMem), 
                                                                    "if-statement", ifStatement.Line));
                result = false;
            }
            result &= ifStatement.If.Accept<bool>(this);
            result &= ifStatement.Else.Accept<bool>(this);
            return result;
        }

        bool IExpressionVisitor<bool>.Visit(AST.Expressions.Binary.Divide expression)
        {
            return this.Visit(expression as Binary_Expression);
        }

        bool IExpressionVisitor<bool>.Visit(AST.Expressions.Binary.Add expression)
        {
            return this.Visit(expression as Binary_Expression);
        }

        bool IExpressionVisitor<bool>.Visit(AST.Expressions.Binary.Subtract expression)
        {
            return this.Visit(expression as Binary_Expression);
        }

        bool IExpressionVisitor<bool>.Visit(AST.Expressions.Binary.Multiply expression)
        {
            return this.Visit(expression as Binary_Expression);
        }

        bool IExpressionVisitor<bool>.Visit(Not expression)
        {
            return this.Visit(expression as Unary_Expression);
        }

        bool IExpressionVisitor<bool>.Visit(AST.Expressions.Binary.LessThan expression)
        {
            return this.Visit(expression as Binary_Expression);
        }

        bool IExpressionVisitor<bool>.Visit(AST.Expressions.Binary.LessThan_Equals expression)
        {
            return this.Visit(expression as Binary_Expression);
        }

        bool IExpressionVisitor<bool>.Visit(AST.Expressions.Binary.GreaterThan expression)
        {
            return this.Visit(expression as Binary_Expression);
        }

        bool IExpressionVisitor<bool>.Visit(AST.Expressions.Binary.GreaterThan_Equals expression)
        {
            return this.Visit(expression as Binary_Expression);
        }

        bool IExpressionVisitor<bool>.Visit(AST.Expressions.Binary.Equals expression)
        {
            return this.Visit(expression as Binary_Expression);
        }

        bool IExpressionVisitor<bool>.Visit(AST.Expressions.Binary.NotEquals expression)
        {
            return this.Visit(expression as Binary_Expression);
        }

        bool IExpressionVisitor<bool>.Visit(AST.Expressions.Binary.Or expression)
        {
            return this.Visit(expression as Binary_Expression);
        }

        bool IExpressionVisitor<bool>.Visit(AST.Expressions.Binary.And expression)
        {
            return this.Visit(expression as Binary_Expression);
        }
    }
}
