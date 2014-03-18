using System;
using System.Globalization;

namespace QL_Csharp.PrimitiveControls
{
    public partial class IntegerControl : StatementControl, IPrimitiveControl<int>
    {
        public IntegerControl(string labelName)
        {
            InitializeComponent();
            label.Text = labelName;
        }

        public void SetValue(int newValue)
        {
            textBoxValue.Text = newValue.ToString(CultureInfo.InvariantCulture);
        }

        public int GetValue()
        {
            int value = 0;
            int.TryParse(textBoxValue.Text, out value);
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