using System;
using System.Windows.Forms;

namespace QL_Csharp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            try
            {
                var output = QL_Main.parse_str(textBoxSource.Text, checkBoxTypeCheck.Enabled);
                textBoxOutput.Text = output.ToString().Replace(";", Environment.NewLine);
            }
            catch (QL_Grammar.ParseErrorException exception)
            {
                QL_Grammar.ParseErrorExceptionMessage data = exception.Data0;
                QL_Grammar.Position startPosition = data.StartPos as QL_Grammar.Position;
                QL_Grammar.Position endPosition = data.EndPos as QL_Grammar.Position;
                textBoxOutput.Text = string.Format("{0} between line {1}, column {2} and line {3} column {4}",
                    data.Message, startPosition.Line, startPosition.Column, endPosition.Line, endPosition.Column);
            }
        }

        private void textBoxSource_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.Control && e.KeyCode == Keys.A)
                textBoxSource.SelectAll();
        }
    }
}
