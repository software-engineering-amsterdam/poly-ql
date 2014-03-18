using System;

namespace QL_Csharp.PrimitiveControls
{
    public partial class StringControl : StatementControl, IPrimitiveControl<string>
    {
        public StringControl(string labelName)
        {
            InitializeComponent();
            label.Text = labelName;
        }

        public void SetValue(string newValue)
        {
            textBoxValue.Text = newValue;
        }

        public string GetValue()
        {
            return textBoxValue.Text;
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