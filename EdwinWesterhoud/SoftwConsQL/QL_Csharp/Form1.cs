using System;
using System.Collections.Generic;
using System.Linq;
using System.Windows.Forms;

namespace QL_Csharp
{
    public partial class Form1 : Form
    {
        Dictionary<string, string> _demoPresets = new Dictionary<string, string>();
        
        public Form1()
        {
            InitializeComponent();

            // Fill demo presets
            _demoPresets.Add("Empty Form", "form formName { }");
            _demoPresets.Add("Questions", "form formName { \r\n\t\"Does it work?\" boolQ1: boolean\r\n\t\"And with two questions?\" boolQ2: boolean\r\n}");
            _demoPresets.Add("Conditional", "form formName {\r\n\t\"Display next question?\" boolQ1: boolean\r\n\tif (boolQ1) {\r\n\t\t\"Did you like it?\" boolQ2: boolean\r\n\t}\r\n}");
            _demoPresets.Add("Assignment", "form formName {\r\n\t\"Income?\" intQ1: integer\r\n\t\"Tax amount\" intTax = intQ1 / 100 * 52\r\n}");
            comboBoxDemos.Items.AddRange(_demoPresets.Keys.ToArray());
        }

        private void buttonGenerate_Click(object sender, EventArgs e)
        {
            try
            {
                var output = QL_Main.parse_str(textBoxSource.Text, checkBoxTypeCheck.Enabled);
                var outputString = output.ToString();
                outputString = outputString.Replace("\n", Environment.NewLine).Replace(";", "");
                textBoxOutput.Text = outputString;
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

        private void comboBoxDemos_SelectedValueChanged(object sender, EventArgs e)
        {
            textBoxSource.Text = _demoPresets[comboBoxDemos.Text];
        }

        protected override bool ProcessCmdKey(ref Message msg, Keys keyData)
        {
            if (keyData == Keys.F5)
            {
                buttonGenerate_Click(this, EventArgs.Empty);
                return true;
            }
            return base.ProcessCmdKey(ref msg, keyData);
        }

        private void textBoxSource_TextChanged(object sender, EventArgs e)
        {
            if (checkBoxRealTime.Checked)
                buttonGenerate_Click(this, EventArgs.Empty);
        }

        private void checkBoxRealTime_CheckedChanged(object sender, EventArgs e)
        {
            buttonGenerate.Enabled = !checkBoxRealTime.Checked;
        }
    }
}
