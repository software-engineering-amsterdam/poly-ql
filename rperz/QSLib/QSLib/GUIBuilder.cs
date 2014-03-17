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
using QSLib.IO;

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

        public static GUIBuilder BuildGUI(Form f)
        {
            GUIBuilder builder = new GUIBuilder();
            f.CreateGUI(builder);
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

        public void CreateStringIO()
        {
            this._currentQuestion.AddIOControl(new StringIO());
        }

        public void CreateIntegerIO()
        {
            this._currentQuestion.AddIOControl(new IntegerIO());
        }

        public void CreateBooleanIO()
        {
            this._currentQuestion.AddIOControl(new BooleanIO());
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
            Binding visibleBinding = new Binding("GetValue");
            visibleBinding.Source = condition;
            visibleBinding.Mode = BindingMode.OneWay;
            visibleBinding.NotifyOnTargetUpdated = true;
            visibleBinding.Converter = new BooleanToVisibilityConverter();
            panel.SetBinding(StackPanel.VisibilityProperty, visibleBinding);
            panel.TargetUpdated +=new EventHandler<DataTransferEventArgs>(OnTargetUpdated);
            this._currentPanel.Children.Add(panel);
            this._currentPanel = panel;

            code.CreateGUI(this);
        }

        private void OnTargetUpdated(Object sender, DataTransferEventArgs args)
        {
            MessageBox.Show("Target has been updated");
        }

        public void AddVisibleIfFalse(QSExpression condition, CodeBlock elseBlock)
        {
            StackPanel panel = new StackPanel();

            // bind the visibility to the negation of the value of the expression
            Binding visibleBinding = new Binding("GetValue");
            visibleBinding.Source = condition;
            visibleBinding.Mode = BindingMode.OneWay;
            visibleBinding.Converter = new NotBoolToVisibilityConverter();
            panel.SetBinding(StackPanel.VisibilityProperty, visibleBinding);           

            this._currentPanel.Children.Add(panel);
            this._currentPanel = panel;

            elseBlock.CreateGUI(this);
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
