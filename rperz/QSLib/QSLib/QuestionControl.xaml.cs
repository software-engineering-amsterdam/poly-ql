using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using QSLib.Expressions.Literals;
using QSLib.Expressions;
namespace QSLib
{
    /// <summary>
    /// Interaction logic for QuestionControl.xaml
    /// </summary>
    public partial class QuestionControl : UserControl
    {

        
        public QuestionControl()
        {
            InitializeComponent();
        }

        public void AddIOControl(Control io)
        {
            this.ioControl = io;
        }

        public object GetValue()
        {
            return this.ioControl.GetValue(ContentProperty);
        }

        public void AddOutputBinding(IExpression expr)
        {
            this.ioControl.DataContext = expr;
            this.ioControl.SetBinding(ContentProperty, "GetValue()");
        }

        public void AddQuestionLabelBinding(QSString qtext)
        {
            this.qTextLbl.DataContext = qtext;
        }

    }
}
