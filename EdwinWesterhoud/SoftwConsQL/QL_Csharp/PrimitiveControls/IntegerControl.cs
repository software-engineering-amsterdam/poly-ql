using System;
using System.ComponentModel;
using System.Drawing;
using System.Globalization;

namespace QL_Csharp.PrimitiveControls
{
    public partial class IntegerControl : StatementControl, IPrimitiveControl<int>
    {
        private int _value;

        public IntegerControl(string labelName)
        {
            InitializeComponent();
            label.Text = labelName;
            textBoxValue.TextChanged += delegate { Validate(); };
        }

        public void SetValue(int newValue)
        {
            _value = newValue;
            textBoxValue.Text = newValue.ToString(CultureInfo.InvariantCulture);
            FireEvent(this, EventArgs.Empty);
        }

        public int GetValue()
        {
            return _value;
        }

        public void SetReadOnly(bool isReadOnly)
        {
            textBoxValue.ReadOnly = isReadOnly;
        }

        private void textBoxValue_Validating(object sender, CancelEventArgs e)
        {
            bool success = int.TryParse(textBoxValue.Text, out _value);
            textBoxValue.ForeColor = success ? Color.Black : Color.Red;
            e.Cancel = !success;
        }

        private void textBoxValue_Validated(object sender, EventArgs e)
        {
            FireEvent(this, EventArgs.Empty);
        }
    }
}