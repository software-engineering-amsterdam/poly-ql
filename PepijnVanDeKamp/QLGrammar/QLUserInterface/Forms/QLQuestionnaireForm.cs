using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace QLUI.WindowsForms.Forms
{
    public partial class QLQuestionnaireForm : Form
    {
        public QLQuestionnaireForm()
        {
            InitializeComponent();
        }

        public void AddControl(Control control)
        {
            flowLayoutPanel1.Controls.Add(control);
        }
    }
}
