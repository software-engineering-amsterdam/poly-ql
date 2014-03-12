using System.Windows.Controls;
using QL.QLClasses.Expressions;
using QL.QLClasses.Expressions.Literals;
using QL.QLClasses.Types;
using QL.QLClasses.Values;
using QL.TypeChecker;

namespace QL.Interpreter.Controls
{
    public class GUITextBox : GUIQuestion
    {
        private TextBox _textBox;

        public GUITextBox(QLMemoryManager memory, string id, string label, QType type, ExpressionBase computation = null)
            : base(memory, id, label, type, computation)
        {
            _textBox = new TextBox{Width = 200, IsReadOnly = false};
            _textBox.LostFocus += _textBox_LostFocus;
            _textBox.LostKeyboardFocus += _textBox_LostFocus;
        }

        public void _textBox_LostFocus(object sender, System.Windows.RoutedEventArgs e)
        {
            Memory.DeclareValue(ID, new StringLiteral(_textBox.Text));
            if (OnChanged != null)
                OnChanged();
        }

        public override void Render()
        {
            base.Render();
            Children.Add(_textBox);

            if (Computation != null)
            {
                _textBox.Text = ((IntValue) Computation.Evaluate()).GetValue().ToString();
            }
        }
    }
}
