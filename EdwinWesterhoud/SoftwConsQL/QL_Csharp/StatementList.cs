using System.Windows.Forms;

namespace QL_Csharp
{
    public partial class StatementList : UserControl
    {
        public StatementList()
        {
            InitializeComponent();
        }

        public void AddControl(Control control)
        {
            statementListPanel.Controls.Add(control);
        }

        public void AddControls(Control[] controls)
        {
            statementListPanel.Controls.AddRange(controls);
        }
    }
}
