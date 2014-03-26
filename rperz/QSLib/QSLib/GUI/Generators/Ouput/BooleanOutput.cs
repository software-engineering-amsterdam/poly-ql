using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
namespace QSLib.IO
{
    public class BooleanOutput : ITypeIO
    {
        private CheckBox _control;

        #region Constructors
        public BooleanOutput()
            : base("GetValue", CheckBox.IsCheckedProperty)
        {
         
        }
        #endregion

        public override  Control GetControl()
        {
            this._control = new CheckBox();
            this._control.IsEnabled = false;
            this._control.Checked += new RoutedEventHandler(_control_Checked);
            this._control.Unchecked += new RoutedEventHandler(_control_Checked);
            return this._control;
        }

        public override System.Windows.Data.Binding GetBinding()
        {
            Binding bindingObject = new Binding(this._binding);
            bindingObject.Source = this._id;
            bindingObject.Mode = BindingMode.OneWay;
            return bindingObject;
        }

        void _control_Checked(object sender, RoutedEventArgs e)
        {
            OnValueChanged(null);
        }
    }
}
