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
        protected string _binding;
        protected DependencyProperty _destinationProperty;


        public ITypeIO(string binding, DependencyProperty property)
        {
            this._binding = binding;
            this._destinationProperty = property;
        }

        public abstract Control GetControl();
        public abstract Binding GetBinding();

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
