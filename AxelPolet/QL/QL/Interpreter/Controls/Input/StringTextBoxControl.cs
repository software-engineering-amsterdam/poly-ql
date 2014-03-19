using System.Windows;
using System.Windows.Controls;
using QL.QLClasses.Values;

namespace QL.Interpreter.Controls.Input
{
    public class StringTextBoxControl : InputControl
    {
        private readonly TextBox _textBox;

        public StringTextBoxControl(string idName, QLMemory memory, bool isComputed = false)
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
            Memory.DeclareValue(IdName, new StringValue(_textBox.Text));

            if (OnChanged != null)
                OnChanged();
        }

        public override void Render()
        {
            _textBox.Text = ((StringValue)Memory.GetDeclaredValue(IdName)).Value();
        }
    }
}
