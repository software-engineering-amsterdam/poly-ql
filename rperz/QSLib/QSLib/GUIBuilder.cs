using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions.Unary;
using QSLib.Expressions;
using System.Windows.Controls;
using System.Windows;
using System.Windows.Data;
using QSLib.Types;

namespace QSLib
{
    public class GUIBuilder
    {
        private StackPanel _control;
        private StackPanel _currentPanel;
        private QuestionControl _currentQuestion;

        private GUIBuilder()
        {
            this._control = new StackPanel();
            this._currentPanel = this._control;
        }

        public void BuildGUI(Form f)
        {
            f.CreateGUI(this);
        }

        internal void CreateIfStatement(IExpression condition, CodeBlock codeBlock, CodeBlock elseBlock)
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

        internal void CreateIO(QSType qsType, bool isInput)
        {
            throw new NotImplementedException();
        }

        public void SetStringInput(Identifier id)
        {
            this._currentQuestion.AddIOControl(new TextBox());
            this._currentQuestion.AddInputBinding(id, TextBox.TextProperty, "SetStringValue");
        }

        public void SetIntegerInput(Identifier id)
        {
            this._currentQuestion.AddIOControl(new TextBox());
            this._currentQuestion.AddInputBinding(id, TextBox.TextProperty, "SetIntegerValue");
        }

        public void SetBooleanInput(Identifier id)
        {
            this._currentQuestion.AddIOControl(new CheckBox());
            this._currentQuestion.AddInputBinding(id, CheckBox.IsCheckedProperty, "SetBooleanValue");
        }

        public void SetStringOutput(Identifier id)
        {
            this._currentQuestion.AddIOControl(new TextBox());
            this._currentQuestion.AddOutputBinding(id, TextBox.TextProperty);
        }

        public void SetIntegerOutput(Identifier id)
        {
            this._currentQuestion.AddIOControl(new TextBox());
            this._currentQuestion.AddOutputBinding(id, TextBox.TextProperty);
        }

        public void SetBooleanOutput(Identifier id)
        {
            this._currentQuestion.AddIOControl(new CheckBox());
            this._currentQuestion.AddOutputBinding(id, CheckBox.IsCheckedProperty);
        }

        public void AddVisibleIfTrue(IExpression condition, CodeBlock code)
        {
            StackPanel panel = new StackPanel();

            // bind the visibility of the panel to the value of the expression
            panel.DataContext = condition;
            panel.SetBinding(StackPanel.IsVisibleProperty, "GetValue");

            this._currentPanel.Children.Add(panel);
            this._currentPanel = panel;

            code.CreateGUI(this);
            this.EndBlock();
        }

        public void AddVisibleIfFalse(IExpression condition, CodeBlock elseBlock)
        {
            StackPanel panel = new StackPanel();
            panel.DataContext = condition;

            // bind the visibility to the negation of the value of the expression
            Binding bind = new Binding("GetValue");
            bind.Converter = new QSLib.NotConverter();
            panel.SetBinding(StackPanel.IsVisibleProperty, bind);
            
            this._currentPanel.Children.Add(panel);
            this._currentPanel = panel;

            elseBlock.CreateGUI(this);
            this.EndBlock();
        }

        public void EndBlock()
        {
            this._currentPanel = (StackPanel)this._currentPanel.Parent;
        }

        public StackPanel GetResult()
        {
            return this._control;
        }

        internal void CreateBooleanIO(bool p)
        {
            throw new NotImplementedException();
        }

        internal void CreateIntegerIO(bool p)
        {
            throw new NotImplementedException();
        }

        internal void CreateStringIO(bool p)
        {
            throw new NotImplementedException();
        }
    }
}
