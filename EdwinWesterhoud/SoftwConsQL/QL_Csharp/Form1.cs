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
                var output = QL_Main.parse_str(textBoxSource.Text);
                textBoxOutput.Text = output.ToString().Replace(";", Environment.NewLine);
            }
            catch (QL_Grammar.ParseErrorException exception)
            {
                QL_Grammar.ParseErrorExceptionMessage data = exception.Data0;
                textBoxOutput.Text = string.Format("{0} at line {1}, column {2}", data.Message, data.Line, data.Column);
            }
        }
    }
}
