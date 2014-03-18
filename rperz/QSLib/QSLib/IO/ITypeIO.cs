using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using QSLib.Expressions.Unary;

namespace QSLib.IO
{
    public abstract class ITypeIO
    {
        protected Identifier _id;
        protected string _binding;
        protected DependencyProperty _destinationProperty;

        #region Constructors
        public ITypeIO(string binding, DependencyProperty property)
        {
            this._binding = binding;
            this._destinationProperty = property;
        }
        #endregion

        public abstract Control GetControl();
        public abstract Binding GetBinding();

        public DependencyProperty GetDependencyProperty()
        {
            return this._destinationProperty;
        }


        public void SetIdentifier(Identifier id)
        {
            this._id = id;
        }

        #region Events
        public event EventHandler ValueChanged;

        protected virtual void OnValueChanged(EventArgs args)
        {
            var handler = this.ValueChanged;
            if (handler != null)
            {
                handler(this, args);
            }
        }
        #endregion
    }
}
