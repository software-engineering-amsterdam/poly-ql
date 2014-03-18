using System;
using System.Globalization;

namespace QL_Csharp.PrimitiveControls
{
    public partial class DecimalControl : StatementControl, IPrimitiveControl<double>
    {
        public DecimalControl(string labelName)
        {
            InitializeComponent();
            label.Text = labelName;
        }

        public void SetValue(double newValue)
        {
            textBoxValue.Text = newValue.ToString(CultureInfo.InvariantCulture);
        }

        public double GetValue()
        {
            double value = 0.0;
            double.TryParse(textBoxValue.Text, out value);
            return value;
        }

        public void SetReadOnly(bool isReadOnly)
        {
            textBoxValue.ReadOnly = isReadOnly;
        }

        private void textBoxValue_TextChanged(object sender, EventArgs e)
        {
            FireEvent(this, EventArgs.Empty);
        }
    }
}