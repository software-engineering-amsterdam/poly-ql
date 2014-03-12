using System.Windows.Controls;
using QL.QLClasses.Expressions;
using QL.QLClasses.Expressions.Literals;
using QL.QLClasses.Types;
using QL.QLClasses.Values;

namespace QL.Interpreter.Controls
{
    public class GUICheckBox : GUIQuestion
    {
        private readonly CheckBox _checkBox;

        public GUICheckBox(QLMemoryManager memory, string id, string label, QType type, ExpressionBase computation = null)
            : base(memory, id, label, type, computation)
        {
            _checkBox = new CheckBox();
            _checkBox.Checked += _checkBox_Checked;
            _checkBox.Unchecked += _checkBox_Checked;
        }

        public void _checkBox_Checked(object sender, System.Windows.RoutedEventArgs e)
        {
            Memory.DeclareValue(ID, new BoolLiteral(_checkBox.IsChecked ?? false));

            if (OnChanged != null)
                OnChanged();
        }

        public override void Render()
        {
            base.Render();
            Children.Add(_checkBox);
            
            if (Computation != null)
            {
                _checkBox.IsChecked = ((BoolValue) Computation.Evaluate()).GetValue(); 
            }
        }
    }
}
