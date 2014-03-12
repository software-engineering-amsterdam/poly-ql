using System.Windows;
using System.Windows.Controls;
using QL.QLClasses.Expressions;
using QL.QLClasses.Types;
using QL.QLClasses.Values;

namespace QL.Interpreter.Controls
{
    public class GUIQuestion : StackPanel
    {
        protected string ID;
        protected Label Label;
        protected QType Type;
        protected QLMemoryManager Memory;
        protected ExpressionBase Computation;

        public ExpressionBase ShowCondition { get; set; }
        public ExpressionBase HideCondition { get; set; }

        public delegate void ChangedEventHandler();
        public ChangedEventHandler OnChanged { get; set; }
        
        public GUIQuestion(QLMemoryManager memory, string id, string label, QType type, ExpressionBase computation = null)
        {
            Memory = memory;

            ID = id;
            Type = type;
            Computation = computation;
            Label = new Label { Content = label, Width = 300 };

            Orientation = Orientation.Horizontal;
            Width = 600;
            Margin = new Thickness(0, 5, 0 ,5);   //magic numbers? --> symbolic constant
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
                Visibility = ((BoolValue)ShowCondition.Evaluate()).GetValue() ? Visibility.Visible : Visibility.Hidden;
            }
            else if(HideCondition != null)
            {
                Visibility = ((BoolValue)HideCondition.Evaluate()).GetValue() ? Visibility.Hidden : Visibility.Visible;
            }
        }
    }
}