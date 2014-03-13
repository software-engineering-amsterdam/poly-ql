using System.Windows;
using System.Windows.Controls;
using QL.QLClasses.Expressions;
using QL.QLClasses.Values;

namespace QL.Interpreter.Controls
{
    public class GUIQuestion : StackPanel
    {
        private readonly Label _label;

        protected QLMemory Memory;
        protected string Identifier;
        protected bool IsComputed;

        public ExpressionBase ShowCondition { get; set; }
        public ExpressionBase HideCondition { get; set; }

        public delegate void ChangedEventHandler();
        public ChangedEventHandler OnChanged { get; set; }
        
        public GUIQuestion(QLMemory memory, string identifier, string label, bool isComputed = true)
        {
            _label = new Label { Content = label, Width = 300 };

            Memory = memory;
            Identifier = identifier;            
            IsComputed = isComputed;
            
            //ui properties
            Orientation = Orientation.Horizontal;
            Width = 600;
            Margin = new Thickness(0, 5, 0 ,5); 
        }

        public virtual void Render()
        {
            CheckVisibility();
            Children.Add(_label);
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