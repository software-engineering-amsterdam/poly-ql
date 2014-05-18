using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using QLUI.WindowsForms.Abstract;

namespace QLUI.WindowsForms.QuestionTypes
{
    public partial class BooleanQuestionControl : QuestionControl
    {
        public BooleanQuestionControl(string Id, String Label, Boolean IsReadOnly)
            : base(Id, Label, IsReadOnly)
        {
            InitializeComponent();
            checkBox1.Text = Label;
            checkBox1.Enabled = !IsReadOnly;
        }

        public BooleanQuestionControl() : base()
        {

        }
    }
}
