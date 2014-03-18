using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
namespace QSLib.IO
{
    public class StringInput : ITypeIO 
    {
        private TextBox _control;

        #region Constructors
        public StringInput()
            : base("SetStringValue", TextBox.TextProperty)
        {
         
        }
        #endregion
        
        public override Control GetControl()
        {
            this._control = new TextBox();
            this._control.TextChanged += new TextChangedEventHandler(_control_TextChanged);
            return this._control;
        }

        public override System.Windows.Data.Binding GetBinding()
        {
            Binding bindingObject = new Binding(this._binding);
            bindingObject.Source = this._id;
            bindingObject.ValidationRules.Add(new ExceptionValidationRule());
            bindingObject.Mode = BindingMode.OneWayToSource;
            bindingObject.UpdateSourceTrigger = UpdateSourceTrigger.PropertyChanged;
            return bindingObject;
        }

        void _control_TextChanged(object sender, RoutedEventArgs e)
        {
            OnValueChanged(null);
        }

    }
}
