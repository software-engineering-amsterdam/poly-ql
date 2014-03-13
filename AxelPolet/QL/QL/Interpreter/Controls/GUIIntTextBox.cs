using System;
using System.Windows.Controls;
using QL.QLClasses.Expressions;
using QL.QLClasses.Expressions.Literals;
using QL.QLClasses.Values;

namespace QL.Interpreter.Controls
{
    public class GUIIntTextBox : GUIQuestion
    {
        private readonly TextBox _textBox;

        public GUIIntTextBox(QLMemory memory, string identifier, string label, bool isComputed = true)
            : base(memory, identifier, label, isComputed)
        {
            _textBox = new TextBox{Width = 200, IsEnabled = IsComputed};
            _textBox.LostFocus += _textBox_LostFocus;
            _textBox.LostKeyboardFocus += _textBox_LostFocus;
        }

        public void _textBox_LostFocus(object sender, System.Windows.RoutedEventArgs e)
        {
            Memory.DeclareValue(Identifier, new IntLiteral(Int32.Parse(_textBox.Text)));

            if (OnChanged != null)
                OnChanged();
        }

        public override void Render()
        {
            base.Render();
            Children.Add(_textBox);

            _textBox.Text = Convert.ToString(((IntValue) Memory.GetDeclaredValue(Identifier).Evaluate()).GetValue());
        }
    }
}
