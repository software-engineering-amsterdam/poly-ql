using System;
using System.Windows.Forms;

namespace QL_Csharp.PrimitiveControls
{
    public class StatementControl : UserControl
    {
        public delegate void ValueChangedEventHandler(StatementControl sender, EventArgs args);
        private event ValueChangedEventHandler ValueChanged;

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