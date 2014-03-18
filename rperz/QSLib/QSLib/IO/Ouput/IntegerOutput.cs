using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;

namespace QSLib.IO
{
    public class IntegerOutput : ITypeIO
    {
        private Label _control;

        public IntegerOutput()
            : base("GetValue", Label.ContentProperty)
        {
         
        }

        public override Control GetControl()
        {
            this._control = new Label();
            this._control.Width = 150;
            this._control.HorizontalContentAlignment = HorizontalAlignment.Right;
            this._control.SourceUpdated    +=new EventHandler<DataTransferEventArgs>(_control_SourceUpdated);
            return this._control;
        }

        void _control_SourceUpdated(object sender, DataTransferEventArgs e)
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