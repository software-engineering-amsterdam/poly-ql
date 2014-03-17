using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Controls;
using System.Windows;
using QSLib.Expressions.Unary;
namespace QSLib.IO
{
    public class IntegerIO : ITypeIO
    {
        private TextBox _control;

        public IntegerIO()
            : base("SetIntegerValue", "GetValue", TextBox.TextProperty)
        {
         
        }

        public override Control GetControl()
        {
            this._control = new TextBox();
            this._control.TextChanged += new TextChangedEventHandler(_control_TextChanged);
            return this._control;
        }

        void _control_TextChanged(object sender, RoutedEventArgs e)
        {
            OnValueChanged(null);
        }

    }
}