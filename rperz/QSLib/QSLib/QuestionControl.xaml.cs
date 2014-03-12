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
using QSLib.Expressions.Unary;
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

        public void AddOutputBinding(Identifier id, DependencyProperty prop)
        {
            this.ioControl.DataContext = id;
            this.ioControl.SetBinding(prop, "GetValue");
        }

        public void AddInputBinding(Identifier id, DependencyProperty prop, string path)
        {
            this.ioControl.DataContext = id;
            this.ioControl.SetBinding(prop, path);
        }

        public void AddQuestionLabel(string qtext)
        {
            this.qTextLbl.Content = qtext;
        }

    }
}
