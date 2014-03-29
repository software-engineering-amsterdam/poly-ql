using System;
using System.Collections.Generic;
using System.Windows.Controls;
using System.Windows.Data;
using QSLib.AST;
using QSLib.AST.Expressions;
using QSLib.AST.Expressions.Unary;
using QSLib.AST.Expressions.Unary.Identifiers;
using QSLib.IO;
using QSLib.Visitors;
namespace QSLib
{
    public class GUIBuilder
    {
        private StackPanel _control;
        private StackPanel _currentPanel;
        private QuestionControl _currentQuestion;
        private IList<QSExpression> _updateList = new List<QSExpression>();
        
        private GUIBuilder()
        {
            this._control = new StackPanel();
            this._currentPanel = this._control;
        }

        public static GUIBuilder BuildGUI(Form questionaire)
        {
            GUIBuilder builder = new GUIBuilder();
            TypeChecker.StartVisit(questionaire);
            questionaire.CreateGUI(builder);
            return builder;
        }

        internal void CreateIfStatement(QSExpression condition, CodeBlock codeBlock, CodeBlock elseBlock)
        {
            AddVisibleIfTrue(condition, codeBlock);
            AddVisibleIfFalse(condition, elseBlock);
        }

        internal void CreateQuestion(string text, Identifier identifier)
        {
            this._currentQuestion = new QuestionControl();
            this._currentQuestion.AddQuestionLabel(text);
            identifier.CreateGUI(this);
            this._currentPanel.Children.Add(this._currentQuestion);
            this._currentQuestion = null;
        }

        public void CreateStringInput()
        {
            this._currentQuestion.AddIOControl(new StringInput());
        }

        public void CreateIntegerInput()
        {
            this._currentQuestion.AddIOControl(new IntegerInput());
        }

        public void CreateBooleanInput()
        {
            this._currentQuestion.AddIOControl(new BooleanInput());
        }

        public void CreateStringOutput()
        {
            this._currentQuestion.AddIOControl(new StringOutput());
        }

        public void CreateIntegerOutput()
        {
            this._currentQuestion.AddIOControl(new IntegerOutput());
        }

        public void CreateBooleanOutput()
        {
            this._currentQuestion.AddIOControl(new BooleanOutput());
        }

        public void SetToInput(Identifier id)
        {
            this._currentQuestion.SetToInput(id);
            this._currentQuestion.ValueChanged += new EventHandler(_currentQuestion_ValueChanged);
        }

        public void SetToOutput(Identifier id)
        {
            this._currentQuestion.SetToOutput(id);
            this._currentQuestion.ValueChanged += new EventHandler(_currentQuestion_ValueChanged);
            this._updateList.Add(id);
        }

        void _currentQuestion_ValueChanged(object sender, EventArgs e)
        {
            foreach (QSExpression expr in this._updateList)
            {
                expr.Evaluate();
            }
        }

        public void AddVisibleIfTrue(QSExpression condition, CodeBlock code)
        {
            StackPanel panel = new StackPanel();

            // bind the visibility to the value of the expression
            this._updateList.Add(condition);

            Binding visibleBinding = GetOneWayBinding("GetValue", condition);
            visibleBinding.Converter = new BooleanToVisibilityConverter();
            panel.SetBinding(StackPanel.VisibilityProperty, visibleBinding);

            this._currentPanel.Children.Add(panel);
            this._currentPanel = panel;

            code.CreateGUI(this);
        }

        public void AddVisibleIfFalse(QSExpression condition, CodeBlock elseBlock)
        {
            StackPanel panel = new StackPanel();

            // bind the visibility to the negation of the value of the expression
            Binding visibleBinding = GetOneWayBinding("GetValue", condition);
            visibleBinding.Converter = new NotBoolToVisibilityConverter();
            panel.SetBinding(StackPanel.VisibilityProperty, visibleBinding);           

            this._currentPanel.Children.Add(panel);
            this._currentPanel = panel;

            elseBlock.CreateGUI(this);
        }

        private Binding GetOneWayBinding(string propertyName, QSExpression expression)
        {
            Binding visibleBinding = new Binding(propertyName);
            visibleBinding.Source = expression;
            visibleBinding.Mode = BindingMode.OneWay;
            return visibleBinding;
        }

        public void EndBlock()
        {
            this._currentPanel = (StackPanel)this._currentPanel.Parent;
        }

        public StackPanel GetResult()
        {
            return this._control;
        }
    }
}
