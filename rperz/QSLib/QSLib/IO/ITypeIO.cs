using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Controls;
using System.Windows.Data;
using QSLib.Expressions.Unary;
using System.Windows;

namespace QSLib.IO
{
    public abstract class ITypeIO
    {
        protected Identifier _id;
        protected string _outputBinding;
        protected string _inputBinding;
        protected DependencyProperty _destinationProperty;


        public ITypeIO(string inputBinding, string outputBinding, DependencyProperty property)
        {
            this._outputBinding = outputBinding;
            this._inputBinding = inputBinding;
            this._destinationProperty = property;
        }

        public abstract Control GetControl();

        public System.Windows.Data.Binding GetInputBinding()
        {
            Binding bindingObject = new Binding(this._inputBinding);
            bindingObject.Source = this._id;
            bindingObject.Mode = BindingMode.OneWayToSource;
            return bindingObject;
        }

        public System.Windows.Data.Binding GetOutputBinding()
        {
            Binding bindingObject = new Binding(this._outputBinding);
            bindingObject.Source = this._id;
            bindingObject.Mode = BindingMode.OneWay;
            return bindingObject;
        }

        public DependencyProperty GetDependencyProperty()
        {
            return this._destinationProperty;
        }

        public event EventHandler ValueChanged;

        protected virtual void OnValueChanged(EventArgs args)
        {
            var handler = this.ValueChanged;
            if (handler != null)
            {
                handler(this, args);
            }
        }

        public void SetIdentifier(Identifier id)
        {
            this._id = id;
        }
    }
}
