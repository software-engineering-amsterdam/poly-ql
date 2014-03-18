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

        public bool GetValue()
        {
            return radioButtonYes.Checked;
        }

        private void radioButtonYes_CheckedChanged(object sender, EventArgs e)
        {
            FireEvent(this, EventArgs.Empty);
        }
    }
}