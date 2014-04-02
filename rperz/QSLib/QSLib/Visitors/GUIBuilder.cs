using System;
using System.Collections.Generic;
using System.Windows.Controls;
using System.Windows.Data;
using QSLib.AST;
using QSLib.AST.Expressions;
using QSLib.AST.Expressions.Unary;
using QSLib.AST.Expressions.Nullary;
using QSLib.Visitors;
using QSLib.AST.Statements;
using System.Windows;
using QSLib.AST.Types;
using System.Text.RegularExpressions;
using QSLib.GUI;
namespace QSLib
{
    public class GUIBuilder : IStatementVisitor<UIElement>, ITypeVisitor<UIElement>
    {
        private UIElement _control;
        private Evaluator _evaluator;
        private IList<Tuple<QSExpression, UIElement>> _conditionList = new List<Tuple<QSExpression, UIElement>>();
        private IList<Tuple<QSExpression, UIElement>> _computedList = new List<Tuple<QSExpression, UIElement>>();
        private GUIBuilder()
        {
            this._control = new StackPanel();
        }

        public static GUIBuilder BuildGUI(Form questionaire)
        {
            GUIBuilder builder = new GUIBuilder();
            TypeChecker.StartVisit(questionaire);
            builder._evaluator = Evaluator.GetEvaluator(questionaire);
            builder._control = questionaire.Accept<UIElement>(builder);
            builder.UpdateComputed();
            return builder;
        }

        public UIElement Visit(Form form)
        {
            StackPanel panel = new StackPanel();
            panel.Children.Add(form.Code.Accept<UIElement>(this));
            panel.Visibility = Visibility.Visible;
            return panel;
        }


        public UIElement Visit(CodeBlock code)
        {
            StackPanel panel = new StackPanel();
            foreach (IStatement stat in code.Statements)
            {
                panel.Children.Add(stat.Accept<UIElement>(this));
            }
            panel.Visibility = Visibility.Visible;
            return panel;
        }


        public UIElement Visit(IfStatement ifStat)
        {
            StackPanel ifBlock = this.AddVisibleIfTrue(ifStat.Condition,  ifStat.If);
            StackPanel elseBlock = this.AddVisibleIfTrue(new Not(ifStat.Condition, ifStat.Line),  ifStat.Else);
            StackPanel result = new StackPanel();
            result.Visibility = Visibility.Visible;
            ifBlock.Visibility = Visibility.Visible;
            elseBlock.Visibility = Visibility.Visible;
            result.Children.Add(ifBlock);
            result.Children.Add(elseBlock);
            return result;
        }

        public UIElement Visit(Question question)
        {
            QuestionControl questionControl = new QuestionControl(question.Id);
            questionControl.AddQuestionLabel(question.Text);
            Control ioControl = question.Type.Accept<UIElement>(this) as Control;

            // create binding to control (writes value of ioControl to value of questionControl)
            Binding bind = new Binding("MyValue");
            bind.Source = questionControl ;
            bind.Converter = question.Type.Accept<IValueConverter>(new ConverterVisitor()) as IValueConverter;
            bind.Mode = BindingMode.OneWayToSource;
            bind.UpdateSourceTrigger = UpdateSourceTrigger.PropertyChanged;
            bind.NotifyOnSourceUpdated = true;
            ioControl.SetBinding(question.Type.Accept<DependencyProperty>(new DependencyPropertyVisitor()) as DependencyProperty , bind);
            questionControl.SourceUpdated += new EventHandler<DataTransferEventArgs>(questionControl_SourceUpdated);
            questionControl.AddIOControl(ioControl, true);

            this._evaluator.SetValue(question.Id, question.Type.GetUndefined());
            questionControl.MyValueChanged += new DependencyPropertyChangedEventHandler(questionControl_ContentChanged);
            return questionControl;
        }

        void questionControl_SourceUpdated(object sender, DataTransferEventArgs e)
        {
            this._evaluator.SetValue(((QuestionControl)sender).Identifier, ((QuestionControl)sender).GetValue(QuestionControl.MyValueProperty));
            UpdateComputed();        
        }

        public UIElement Visit(IntegerType type)
        {
            TextBox tbIO = new TextBox();
            tbIO.Text = "0";
            tbIO.Width = 150;
            tbIO.PreviewTextInput += new System.Windows.Input.TextCompositionEventHandler(tbIO_PreviewTextInput);
            return tbIO;
        }

        void tbIO_PreviewTextInput(object sender, System.Windows.Input.TextCompositionEventArgs e)
        {
            if (Regex.IsMatch(e.Text, @"\D"))
                e.Handled = true;
        }
        public UIElement Visit(StringType type)
        {
            TextBox tbIO = new TextBox();
            tbIO.Width = 150;
            tbIO.Text = "";
            return tbIO;
        }
        public UIElement Visit(BoolType type)
        {
            CheckBox cbIO = new CheckBox();
            cbIO.IsChecked = false;
            return cbIO;
        }

        public UIElement Visit(ComputedQuestion question)
        {
            QuestionControl questionControl = new QuestionControl(question.Id);
            questionControl.AddQuestionLabel(question.Text);
            Control ioControl = question.Type.Accept<UIElement>(this) as Control;

            // create binding to control (writes value of questionControl to value of ioControl)
            Binding bind = new Binding("MyValue");
            bind.Source = questionControl;
            bind.Converter = question.Type.Accept<IValueConverter>(new ConverterVisitor()) as IValueConverter;
            bind.Mode = BindingMode.OneWay;
            bind.FallbackValue = "";
            bind.UpdateSourceTrigger = UpdateSourceTrigger.PropertyChanged;
            bind.NotifyOnTargetUpdated = true;
            ioControl.SetBinding(question.Type.Accept<DependencyProperty>(new DependencyPropertyVisitor()) as DependencyProperty, bind);
            questionControl.AddIOControl(ioControl, false);
            this._computedList.Add(new Tuple<QSExpression, UIElement>(question.Expression, questionControl));
            return questionControl;
        }



        void questionControl_ContentChanged(object sender, DependencyPropertyChangedEventArgs e)
        {
            this._evaluator.SetValue(((QuestionControl)sender).Identifier, e.NewValue);
            UpdateComputed();
        }

        private void UpdateComputed()
        {
            foreach (Tuple<QSExpression, UIElement> element in this._computedList)
            {
                
                element.Item2.SetValue(QuestionControl.MyValueProperty, element.Item1.Accept<object>(this._evaluator));
            }
            foreach (Tuple<QSExpression, UIElement> element in this._conditionList)
            {
                bool? condition = element.Item1.Accept<object>(this._evaluator) as bool?;
                if ((bool)condition)
                    element.Item2.SetValue(Panel.VisibilityProperty, Visibility.Visible);
                else
                    element.Item2.SetValue(Panel.VisibilityProperty, Visibility.Collapsed);
            }
        }

        public StackPanel AddVisibleIfTrue(QSExpression condition, CodeBlock code)
        {
            StackPanel panel = new StackPanel();
            panel.Children.Add((UIElement)code.Accept(this));
            this._conditionList.Add(new Tuple<QSExpression,UIElement>(condition, panel));

            return panel;
        }

        public UIElement Result
        {
            get
            {
                return this._control;
            }
        }
    }
}
