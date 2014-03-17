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
using QSLib.IO;

namespace QSLib
{
    /// <summary>
    /// Interaction logic for QuestionControl.xaml
    /// </summary>
    public partial class QuestionControl : UserControl
    {
        private Control _iocontrol;
        private ITypeIO _typeIO;
        public QuestionControl()
        {
            InitializeComponent();
        }

        public void AddIOControl(ITypeIO io)
        {
            this._iocontrol = io.GetControl();
            this._typeIO = io;
            this.ioControl.Children.Add(this._iocontrol);
        }

        public void SetToInput(Identifier id)
        {
            this._typeIO.SetIdentifier(id);
            this._typeIO.ValueChanged += new EventHandler(_typeIO_ValueChanged);
            this._iocontrol.SetBinding(this._typeIO.GetDependencyProperty(), this._typeIO.GetInputBinding());
        }

        void _typeIO_ValueChanged(object sender, EventArgs e)
        {
            OnValueChanged(null);
        }

        internal void SetToOutput(Identifier id)
        {
            this._typeIO.SetIdentifier(id);
            this._iocontrol.SetBinding(this._typeIO.GetDependencyProperty(), this._typeIO.GetOutputBinding());
        }

        public event EventHandler ValueChanged;

        protected virtual void OnValueChanged(EventArgs args)
        {
            var handler = this.ValueChanged;
            if (handler != null)
            {
                handler(this, args);
            }
        }

        public void AddQuestionLabel(string qtext)
        {
            this.qTextLbl.Content = qtext;
        }

    }
}
