using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace QLUI.WindowsForms.Abstract
{
    public class QuestionControl : UserControl
    {
        private string id;
        private string label;
        private Boolean isreadonly;

        public QuestionControl() { }

        public QuestionControl(String Id, String Label, Boolean IsReadOnly)
        {
            this.id = Id;
            this.label = Label;
            this.isreadonly = IsReadOnly;
        }

        protected virtual void OnValueChanged(EventArgs e)
        {
            var _handler = ValueChanged;
            if (_handler != null)
                _handler(this, e);
        }

        public event EventHandler ValueChanged;

        public String Id
        {
            get
            {
                return id;
            }
        }



    }
}
