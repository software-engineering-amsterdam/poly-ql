using System;
using System.Windows;
using System.Windows.Controls;
using QSLib.AST.Expressions.Unary.Identifiers;
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
            this._iocontrol.VerticalAlignment = System.Windows.VerticalAlignment.Center;
            this._iocontrol.HorizontalAlignment = System.Windows.HorizontalAlignment.Right;
            this._iocontrol.Margin = new Thickness(0,7.5,0, 7.5);
            this._typeIO = io;
            this.ioControl.Children.Add(this._iocontrol);
        }

        public void SetToInput(Identifier id)
        {
            this._typeIO.SetIdentifier(id);
            this._typeIO.ValueChanged += new EventHandler(_typeIO_ValueChanged);
            this._iocontrol.SetBinding(this._typeIO.GetDependencyProperty(), this._typeIO.GetBinding());
        }

        void _typeIO_ValueChanged(object sender, EventArgs e)
        {
            OnValueChanged(null);
        }

        internal void SetToOutput(Identifier id)
        {
            this._typeIO.SetIdentifier(id);
   
            this._iocontrol.SetBinding(this._typeIO.GetDependencyProperty(), this._typeIO.GetBinding());
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
            this.qTextLbl.Text = qtext;
        }

    }
}
