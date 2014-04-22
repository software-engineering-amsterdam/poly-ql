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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnLoad_Click(object sender, EventArgs e)
        {
            txtInput.Text = File.ReadAllText(ConfigurationManager.AppSettings["example"]);
        }

        private void btnParse_Click(object sender, EventArgs e)
        {
            var _form = QL.Parsing.Parse(txtInput.Text);
            txtOutput.Text = _form.ToString().Replace("\n",Environment.NewLine);

            List<QL.TypeChecker.ITypeRule> _rules = new List<QL.TypeChecker.ITypeRule>();
            _rules.Add(new QL.TypeChecker.DuplicateLabelsRule());
            _rules.Add(new QL.TypeChecker.ReferenceUndefinedQuestionsRule());
            _rules.Add(new QL.TypeChecker.DuplicateQuestionDeclarationsMustBeOfSameTypeRule());
            QL.TypeChecker.TypeChecker _checker = new QL.TypeChecker.TypeChecker(_rules);
            var _messages = _checker.getMessages(_form);

            txtCheckerMessages.Text = String.Join(Environment.NewLine, _messages.Select(_m => _m.ToString()).ToArray());

           
        }
    }
}
