using System.Windows.Controls;
using QL.QLClasses.Values;

namespace QL.Interpreter.Controls.Input
{
    public class CheckBoxControl : InputControl
    {
        private readonly CheckBox _checkBox;
     
        public CheckBoxControl(string idName, QLMemory memory, bool isComputed = false)
            : base(idName, memory, isComputed)
        {
            _checkBox = new CheckBox {IsEnabled = !isComputed};
            _checkBox.Checked += _checkBox_Checked;
            _checkBox.Unchecked += _checkBox_Checked;
            Children.Add(_checkBox);
        }

        public void _checkBox_Checked(object sender, System.Windows.RoutedEventArgs e)
        {
            Memory.DeclareValue(IdName, new BoolValue(_checkBox.IsChecked ?? false));

            if (OnChanged != null)
                OnChanged();
        }

        public override void Render()
        {
            _checkBox.IsChecked = ((BoolValue)Memory.GetDeclaredValue(IdName)).GetValue();
        }
    }
}
