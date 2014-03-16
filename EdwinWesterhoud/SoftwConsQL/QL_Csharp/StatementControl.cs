using System.Windows.Forms;

namespace QL_Csharp
{
    public partial class StatementControl : UserControl
    {
        public StatementControl(string labelName)
        {
            InitializeComponent();

            var label = new Label { Text = labelName };
            var margin = label.Margin;
            margin.Top = 5;
            label.Margin = margin;
            statementPanel.Controls.Add(label);
        }

        public void AddControl(Control control)
        {
            statementPanel.Controls.Add(control);
        }

        public void AddControls(Control[] controls)
        {
            statementPanel.Controls.AddRange(controls);
        }
    }
}