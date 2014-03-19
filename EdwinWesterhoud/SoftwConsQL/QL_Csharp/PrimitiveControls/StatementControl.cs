using System;
using System.Windows.Forms;

namespace QL_Csharp.PrimitiveControls
{
    public class StatementControl : UserControl
    {
        public delegate void ValueChangedEventHandler(StatementControl sender, EventArgs args);
        private event ValueChangedEventHandler ValueChanged;

        // Allow no instantiation (apart from subclassing)
        // The class should be abstract, I know. But it cannot be, because of the Visual Studio Designer.
        protected StatementControl()
        {
            
        }

        public void AddValueChangedEventHandler(ValueChangedEventHandler handler)
        {
            ValueChanged += handler;
        }

        protected void FireEvent(StatementControl sender, EventArgs args)
        {
            if (ValueChanged != null)
            {
                ValueChanged(sender, args);
            }
        }
    }
}