using System.Windows.Controls;
using QL.QLClasses.Expressions.Literals;
using QL.QLClasses.Values;

namespace QL.Interpreter.Controls
{
    public class GUICheckBox : GUIQuestion
    {
        private readonly CheckBox _checkBox;

        public GUICheckBox(QLMemory memory, string identifier, string label, bool isComputed = true)
            : base(memory, identifier, label, isComputed)
        {
            _checkBox = new CheckBox {IsEnabled = IsComputed};
            _checkBox.Checked += _checkBox_Checked;
            _checkBox.Unchecked += _checkBox_Checked;
        }

        public void _checkBox_Checked(object sender, System.Windows.RoutedEventArgs e)
        {
            Memory.DeclareValue(Identifier, new BoolLiteral(_checkBox.IsChecked ?? false));

            if (OnChanged != null)
                OnChanged();
        }

        public override void Render()
        {
            base.Render();
            Children.Add(_checkBox);

            _checkBox.IsChecked = ((BoolValue)Memory.GetDeclaredValue(Identifier).Evaluate()).GetValue(); 
        }
    }
}
