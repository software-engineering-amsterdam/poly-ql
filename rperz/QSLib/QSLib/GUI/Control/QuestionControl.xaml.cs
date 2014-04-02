using System;
using System.Windows;
using System.Windows.Controls;
using QSLib.AST.Expressions.Nullary;
using QSLib.AST.Types;
using System.Windows.Input;
using QSLib.GUI;

namespace QSLib
{
    /// <summary>
    /// Interaction logic for QuestionControl.xaml
    /// </summary>
    public partial class QuestionControl : UserControl
    {
        private Control _iocontrol;
        private string _id;
        public QuestionControl(string id)
        {
            InitializeComponent();
            this._id = id;
        }
        public Control IOControl
        {
            get
            {
                return this._iocontrol;
            }
        }
        public void AddIOControl(Control control, bool isInput)
        {
            this._iocontrol = control;
            this._iocontrol.VerticalAlignment = System.Windows.VerticalAlignment.Center;
            this._iocontrol.HorizontalAlignment = System.Windows.HorizontalAlignment.Right;
            this._iocontrol.Margin = new Thickness(0, 7.5, 0, 7.5);
            this._iocontrol.IsEnabled = isInput;
            this.ioControl.Children.Add(this._iocontrol);
        }
 
        public object MyValue
        {
            get { return (object)GetValue(MyValueProperty); }
            set { SetValue(MyValueProperty, value); }
        }
        public string Identifier
        {
            get
            {
                return this._id;
            }
        }
        // Using a DependencyProperty as the backing store for Content.  This enables animation, styling, binding, etc...
        public static readonly DependencyProperty MyValueProperty =
            DependencyProperty.Register("MyValue", typeof(object), typeof(QuestionControl), new UIPropertyMetadata(0));

        public event DependencyPropertyChangedEventHandler MyValueChanged;
        protected void OnPropertyChanged(object sender, DependencyPropertyChangedEventArgs e)
        {

            if (e.Property  == MyValueProperty)
            {
                var handler = MyValueChanged;
                if (handler != null)
                {
                    handler(this, e);
                }
            }
            base.OnPropertyChanged(e);
        }

        public void AddQuestionLabel(string qtext)
        {
            this.qTextLbl.Text = qtext;
        }

    }
}
