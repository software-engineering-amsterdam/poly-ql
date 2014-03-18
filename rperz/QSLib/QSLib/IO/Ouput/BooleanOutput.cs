using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Controls;
using System.Windows;
using QSLib.Expressions.Unary;
using System.Windows.Data;
namespace QSLib.IO
{
    public class BooleanOutput : ITypeIO
    {
        private CheckBox _control;

        public BooleanOutput()
            : base("GetValue", CheckBox.IsCheckedProperty)
        {
         
        }

        public override  Control GetControl()
        {
            this._control = new CheckBox();
            this._control.IsEnabled = false;
            this._control.Checked += new RoutedEventHandler(_control_Checked);
            this._control.Unchecked += new RoutedEventHandler(_control_Checked);
            return this._control;
        }

        void _control_Checked(object sender, RoutedEventArgs e)
        {
            OnValueChanged(null);
        }

        public override System.Windows.Data.Binding GetBinding()
        {
            Binding bindingObject = new Binding(this._binding);
            bindingObject.Source = this._id;
            bindingObject.Mode = BindingMode.OneWay;
            return bindingObject;
        }
    }
}
