using System;
using System.Drawing;
using System.Globalization;

namespace QL_Csharp.PrimitiveControls
{
    public partial class DecimalControl : StatementControl, IPrimitiveControl<double>
    {
        private double _value;

        public DecimalControl(string labelName)
        {
            InitializeComponent();
            label.Text = labelName;
            textBoxValue.TextChanged += delegate { Validate(); };
        }

        public void SetValue(double newValue)
        {
            _value = newValue;
            textBoxValue.Text = newValue.ToString(CultureInfo.InvariantCulture);
            FireEvent(this, EventArgs.Empty);
        }

        public double GetValue()
        {
            return _value;
        }

        public void SetReadOnly(bool isReadOnly)
        {
            textBoxValue.ReadOnly = isReadOnly;
        }

        private void textBoxValue_Validating(object sender, System.ComponentModel.CancelEventArgs e)
        {
            bool success = double.TryParse(textBoxValue.Text, NumberStyles.AllowDecimalPoint, NumberFormatInfo.InvariantInfo, out _value);
            textBoxValue.ForeColor = success ? Color.Black : Color.Red;
            e.Cancel = !success;
        }

        private void textBoxValue_Validated(object sender, EventArgs e)
        {
            FireEvent(this, EventArgs.Empty);
        }
    }
}