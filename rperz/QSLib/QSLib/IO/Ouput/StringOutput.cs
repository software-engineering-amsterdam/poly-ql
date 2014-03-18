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
    public class StringOutput : ITypeIO 
    {
        private Label _control;

        public StringOutput()
            : base("GetValue", Label.ContentProperty)
        {
         
        }

        public override Control GetControl()
        {
            this._control = new Label();
            this._control.SourceUpdated += new EventHandler<System.Windows.Data.DataTransferEventArgs>(_control_SourceUpdated);
            return this._control;
        }

        void _control_SourceUpdated(object sender, System.Windows.Data.DataTransferEventArgs e)
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
