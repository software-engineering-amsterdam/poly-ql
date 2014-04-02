using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.AST.Expressions.Binary;
using QSLib.AST.Expressions.Unary;
using QSLib.AST.Expressions.Literals;
using QSLib.AST.Expressions.Nullary;
using QSLib.AST;
using QSLib.AST.Statements;
using QSLib.AST.Expressions;
namespace QSLib.Visitors
{
    public class Evaluator : IVisitor<object>
    {
        private IDictionary<string, object> _valueMem = new Dictionary<string, object>();
        private Form _form;
        private Evaluator(Form form)
        {
            this._form = form;
        }

        public static Evaluator GetEvaluator(Form f)
        {
            Evaluator eval;
            eval = new Evaluator(f);
            eval._form.Accept<object>(eval);

            return eval;
        }

        public void SetValue(string id, object value)
        {
            if (this._valueMem.ContainsKey(id))
                this._valueMem.Remove(id);
            this._valueMem.Add(id, value);
        }

        public event EventHandler ValueChanged;

        public void OnValueChanged(EventArgs args)
        {
            var handler = ValueChanged;
            if (handler != null)
            {
                handler(this, args);
            }
        }
     

        public object GetValue(string id)
        {
            object value;
            this._valueMem.TryGetValue(id, out value);
            return value;
        }

        public object Visit(Add expression)
        {
            object leftValue = expression.Left.Accept<object>(this);
            object rightValue = expression.Right.Accept<object>(this);
            return (int)leftValue + (int)rightValue;
        }
        public object Visit(Subtract expression)
        {
            
            object leftValue = expression.Left.Accept<object>(this);
            object rightValue = expression.Right.Accept<object>(this);
            return (int)leftValue - (int)rightValue;
        }
        public object Visit(Divide expression)
        {
            object leftValue = expression.Left.Accept<object>(this);
            object rightValue = expression.Right.Accept<object>(this);
            if ((int)rightValue == 0)
                return 0;
            return (int)leftValue / (int)rightValue;
        }
        public object Visit(Multiply expression)
        {
            object leftValue = expression.Left.Accept<object>(this);
            object rightValue = expression.Right.Accept<object>(this);
            return (int)leftValue * (int)rightValue;
        }
        public object Visit(LessThan expression)
        {
            object leftValue = expression.Left.Accept<object>(this);
            object rightValue = expression.Right.Accept<object>(this);
            return (int)leftValue < (int)rightValue;
        }
        public object Visit(LessThan_Equals expression)
        {
            object leftValue = expression.Left.Accept<object>(this);
            object rightValue = expression.Right.Accept<object>(this);
            return (int)leftValue <= (int)rightValue;
        }
        public object Visit(GreaterThan expression)
        {
            object leftValue = expression.Left.Accept<object>(this);
            object rightValue = expression.Right.Accept<object>(this);
            return (int)leftValue > (int)rightValue;
        }
        public object Visit(GreaterThan_Equals expression)
        {
            object leftValue = expression.Left.Accept<object>(this);
            object rightValue = expression.Right.Accept<object>(this);
            return (int)leftValue >= (int)rightValue;
        }
        public object Visit(Equals expression)
        {
            object leftValue = expression.Left.Accept<object>(this);
            object rightValue = expression.Right.Accept<object>(this);
            return (int)leftValue == (int)rightValue;
        }
        public object Visit(NotEquals expression)
        {
            object leftValue = expression.Left.Accept<object>(this);
            object rightValue = expression.Right.Accept<object>(this);
            return (int)leftValue != (int)rightValue;
        }
        public object Visit(Not expression)
        {
            object internValue = expression.Internal.Accept<object>(this);
            return !(bool)internValue;
        }
        public object Visit(Primary expression)
        {
            object internValue = expression.Value;
            return internValue;
        }
        public object Visit(Identifier id)
        {
            object value;
            this._valueMem.TryGetValue(id.Name, out value);
            return value;
        }
        public object Visit(And expression)
        {
            object leftValue = expression.Left.Accept<object>(this);
            object rightValue = expression.Right.Accept<object>(this);
            return (bool)leftValue && (bool)rightValue;
        }
        public object Visit(Or expression)
        {
            object leftValue = expression.Left.Accept<object>(this);
            object rightValue = expression.Right.Accept<object>(this);
            return (bool)leftValue || (bool)rightValue;
        }


        public object Result
        {
            get { throw new NotImplementedException(); }
        }

        public object Visit(Form form)
        {
            return form.Code.Accept<object>(this);
        }

        public object Visit(IfStatement ifStatement)
        {
            object value = ifStatement.Condition.Accept<object>(this);

            ifStatement.If.Accept<object>(this);
            ifStatement.Else.Accept<object>(this);
            return value;
        }

        public object Visit(Question question)
        {
            object value;
            if (!this._valueMem.TryGetValue(question.Id, out value))
                this._valueMem.Add(question.Id, question.Type.GetUndefined());
            return value;
        }

        public object Visit(ComputedQuestion computedQuestion)
        {
            object value = computedQuestion.Expression.Accept<object>(this);
            this._valueMem.Add(computedQuestion.Id, value);
            return value;
        }

        public object Visit(CodeBlock codeBlock)
        {
            foreach (IStatement statement in codeBlock.Statements)
            {
                statement.Accept<object>(this);
            }
            return null;
        }
        public object Visit(Unary_Expression expression)
        {
            throw new NotImplementedException();
        }
        public object Visit(Binary_Expression expression)
        {
            throw new NotImplementedException();
        }
    }
}
