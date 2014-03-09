using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using QL.QLClasses.Expressions;
using QL.QLClasses.Types;

namespace QL.Interpreter.Controls
{
    public class GUIQuestion : StackPanel
    {
        protected string ID;
        protected Label Label;
        protected QBaseType Type;
        protected QLMemoryManager Memory;
        protected ExpressionBase Computation;

        public ExpressionBase ShowCondition { get; set; }
        public List<ExpressionBase> DoNotShowConditions { get; set; }

        public delegate void ChangedEventHandler();
        public ChangedEventHandler OnChanged { get; set; }
        
        public GUIQuestion(QLMemoryManager memory, string id, string label, QBaseType type, ExpressionBase computation = null)
        {
            Memory = memory;

            ID = id;
            Type = type;
            Computation = computation;
            Label = new Label { Content = label, Width = 300 };

            Orientation = Orientation.Horizontal;
            Width = 600;
            Margin = new Thickness(0, 5, 0 ,5);
        }

        public virtual void Render()
        {
            CheckVisibility();
            Children.Add(Label);
        }

        public virtual void Refresh()
        {
            Children.Clear();
        }

        private void CheckVisibility()
        {
            if (ShowCondition != null)
            {
                Visibility = Convert.ToBoolean(ShowCondition.GetResult().ToString()) ? Visibility.Visible : Visibility.Hidden;
            }
        }
    }
}