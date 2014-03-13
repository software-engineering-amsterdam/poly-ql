using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using ICSharpCode.TextEditor.Document;

namespace QL_Csharp
{
    public partial class Form1 : Form
    {
        readonly Dictionary<string, string> _demoPresets = new Dictionary<string, string>();
        
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

        public void AddClickEventHandler(EventHandler handler)
        {
            buttonGenerate.Click += handler;
        }

        public bool CheckTypes
        {
            get { return checkBoxTypeCheck.Checked; }
        }

        public string InputText
        {
            get { return textBoxSource.Text; }
        }

        public void SetOutputText(string newText)
        {
            string cleanText = newText.Replace("\n", Environment.NewLine).Replace(";", "");
            textBoxOutput.Text = cleanText;
        }

        public void UnderlineParseError(int startPosition, int length)
        {
            var marker = new TextMarker(startPosition, length, TextMarkerType.WaveLine, Color.Red);
            textBoxSource.Document.MarkerStrategy.AddMarker(marker);
            textBoxSource.Refresh();
        }

        private void comboBoxDemos_SelectedValueChanged(object sender, EventArgs e)
        {
            textBoxSource.Text = _demoPresets[comboBoxDemos.Text];
        }

        protected override bool ProcessCmdKey(ref Message msg, Keys keyData)
        {
            if (keyData == Keys.F5)
            {
                buttonGenerate.PerformClick();
                return true;
            }
            return base.ProcessCmdKey(ref msg, keyData);
        }

        private void textBoxSource_TextChanged(object sender, EventArgs e)
        {
            // Remove markers
            textBoxSource.Document.MarkerStrategy.RemoveAll(marker => true);
            textBoxSource.Refresh();
        }
    }
}
