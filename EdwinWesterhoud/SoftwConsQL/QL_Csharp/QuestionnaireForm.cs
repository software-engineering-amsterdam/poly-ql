using System.Windows.Forms;

namespace QL_Csharp
{
    public partial class QuestionnaireForm : Form
    {
        public QuestionnaireForm(string formName)
        {
            InitializeComponent();
            AutoValidate = AutoValidate.EnableAllowFocusChange;
            Text = formName;
        }

        public void AddControl(Control control)
        {
            statementList1.AddControl(control);
        }

        public void AddControls(Control[] controls)
        {
            statementList1.AddControls(controls);
        }
    }
}