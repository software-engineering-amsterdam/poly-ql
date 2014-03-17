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
    public class BooleanIO : ITypeIO
    {
        private CheckBox _control;

        public BooleanIO()
            : base("SetBooleanValue", "GetValue", CheckBox.IsCheckedProperty)
        {
         
        }

        public override  Control GetControl()
        {
            this._control = new CheckBox();
            this._control.Checked += new RoutedEventHandler(_control_Checked);
            this._control.Unchecked += new RoutedEventHandler(_control_Checked);
            return this._control;
        }

        void _control_Checked(object sender, RoutedEventArgs e)
        {
            OnValueChanged(null);
        }


    }
}
