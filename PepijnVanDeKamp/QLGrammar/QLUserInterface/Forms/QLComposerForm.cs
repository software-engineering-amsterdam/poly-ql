using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace QLUserInterface
{
    public partial class QLComposerForm : Form
    {
        public QLComposerForm()
        {
            InitializeComponent();
        }

        private void btnLoad_Click(object sender, EventArgs e)
        {
            txtInput.Text = File.ReadAllText(ConfigurationManager.AppSettings["example"]);
        }

        public String getInputString()
        {
            return txtInput.Text;
        }

        public void setParseTree(String ParseTree)
        {
            txtOutput.Text = ParseTree;
        }

        public void setMessages(String Messages)
        {
            txtCheckerMessages.Text = Messages;
        }

        public void AddParseEventHandler(EventHandler handler)
        {
            btnParse.Click += handler;
        }
    }
}
