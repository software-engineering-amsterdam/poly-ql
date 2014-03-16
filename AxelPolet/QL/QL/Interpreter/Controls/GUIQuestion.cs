using System.Collections.Generic;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using QL.Interpreter.Controls.Input;
using QL.QLClasses.Expressions;
using QL.QLClasses.Values;

namespace QL.Interpreter.Controls
{
    public class GUIQuestion : StackPanel
    {
        public delegate void ChangedEventHandler();

        private readonly QLMemory _memory;
        private readonly string _identifier;
        private readonly Label _label;
        private readonly bool _isComputed;

        private readonly List<ExpressionBase> _hideConditions;
        private ExpressionBase _showCondition;      
        
        private readonly InputControl _input;
        
        public GUIQuestion(QLMemory memory, string identifier, string label, bool isComputed, ExpressionBase showCondition, ChangedEventHandler changeHandler)
        {
            _hideConditions = new List<ExpressionBase>();
            _showCondition = showCondition;

            _memory = memory;
            _identifier = identifier;            
            _isComputed = isComputed;
            
            _label = new Label { Content = label, Width = 300 };
            _input = _memory.GetDeclaredValue(_identifier).CreateInputControl(_identifier, _memory, _isComputed);
            _input.OnChanged = changeHandler;
            
            //ui properties
            Orientation = Orientation.Horizontal;
            Width = 600;
            Margin = new Thickness(0, 5, 0 ,5); 
        }

        public void Render()
        {
            CheckVisibility();
            Children.Add(_label);
            Children.Add(_input);

            _input.Render();
        }

        public void Refresh()
        {
            Children.Clear();
        }
        
        public void AppendHideCondition(ExpressionBase condition)
        {
            _hideConditions.Add(condition);
        }

        public void SetShowCondition(ExpressionBase showCondition)
        {
            _showCondition = showCondition;
        }

        private void CheckVisibility()
        {
            if (_showCondition != null)
            {
                Visibility = (((BoolValue)_showCondition.Evaluate()).GetValue() && !CheckHideConditions()) 
                    ? Visibility.Visible 
                    : Visibility.Hidden;
            }
            else if(_hideConditions.Any())
            {
                Visibility = CheckHideConditions() ? Visibility.Hidden : Visibility.Visible;
            }
        }

        private bool CheckHideConditions()
        {
            return (_hideConditions.Any(h => ((BoolValue) h.Evaluate()).GetValue()));
        }
    }
}