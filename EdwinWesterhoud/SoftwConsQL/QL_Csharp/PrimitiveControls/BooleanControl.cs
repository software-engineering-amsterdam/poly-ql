using System;

namespace QL_Csharp.PrimitiveControls
{
    public partial class BooleanControl : StatementControl, IPrimitiveControl<bool>
    {
        public BooleanControl(string labelName)
        {
            InitializeComponent();
            label.Text = labelName;
        }

        public void SetValue(bool newValue)
        {
            radioButtonYes.Checked = newValue;
            radioButtonNo.Checked = !newValue;
        }

        public bool GetValue()
        {
            return radioButtonYes.Checked;
        }

        public void SetReadOnly(bool isReadOnly)
        {
            radioButtonYes.Enabled = !isReadOnly;
            radioButtonNo.Enabled = !isReadOnly;
        }

        private void radioButtonYes_CheckedChanged(object sender, EventArgs e)
        {
            FireEvent(this, EventArgs.Empty);
        }
    }
}