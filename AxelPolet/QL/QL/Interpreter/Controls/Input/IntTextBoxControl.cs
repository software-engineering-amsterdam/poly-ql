using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using QL.QLClasses.Values;

namespace QL.Interpreter.Controls.Input
{
    public class IntTextBoxControl : InputControl
    {
        private readonly TextBox _textBox;

        public IntTextBoxControl(string idName, QLMemory memory, bool isComputed = false)
            : base(idName, memory, isComputed)
        {
            _textBox = new TextBox
                {
                    Width = 150,
                    IsEnabled = !IsComputed,
                    HorizontalAlignment = HorizontalAlignment.Left
                };

            _textBox.LostFocus += _textBox_LostFocus;
            _textBox.LostKeyboardFocus += _textBox_LostFocus;
            _textBox.KeyUp += _textBox_LostFocus;

            Children.Add(_textBox);
        }

        public void _textBox_LostFocus(object sender, RoutedEventArgs e)
        {
            int value;
            if (Int32.TryParse(_textBox.Text, out value))
            {
                Memory.DeclareValue(IdName, new IntValue(value));

                if (OnChanged != null)
                    OnChanged();
            }
            else
            {
                _textBox.BorderBrush = new SolidColorBrush(Colors.Red);
            }
        }

        public override void Render()
        {
            _textBox.BorderBrush = null;
            _textBox.Text = Convert.ToString(((IntValue)Memory.GetDeclaredValue(IdName)).Value());
        }
    }
}
