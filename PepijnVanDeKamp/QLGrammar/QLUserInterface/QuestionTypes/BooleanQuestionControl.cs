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
using QL;

namespace QLUI.WindowsForms.QuestionTypes
{
    public partial class BooleanQuestionControl : QuestionControl, IPrimitiveValue<Boolean>
    {
        public BooleanQuestionControl(string Id, String Label, Boolean IsReadOnly)
            : base(Id, Label, IsReadOnly)
        {
            InitializeComponent();
            checkBox1.Text = Label;
            checkBox1.Enabled = !IsReadOnly;
            checkBox1.CheckedChanged += checkBox1_CheckedChanged;
        }

        void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            OnValueChanged(e);
        }

        public bool GetValue()
        {
            return checkBox1.Checked;
        }

        public void SetValue(bool Value)
        {
            checkBox1.Checked = Value;
        }


    }
}
