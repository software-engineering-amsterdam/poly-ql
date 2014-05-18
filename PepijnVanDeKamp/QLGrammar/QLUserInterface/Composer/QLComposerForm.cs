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

        private void btnParse_Click(object sender, EventArgs e)
        {

            //QL.Parsing.Parser _parser = new QL.Parsing.Parser();

            //var _parseresult = _parser.Parse(txtInput.Text);
            //var _messages = _parseresult.Messages;

            //if (FSharpOption<QL.AbstractSyntaxTree.Form>.get_IsSome(_parseresult.ParseTree))
            //{
            //    var _parseTree = _parseresult.ParseTree.Value;
            //    txtOutput.Text = _parseTree.ToString().Replace("\n", Environment.NewLine);

            //    var _rules = new List<QL.TypeChecking.ITypeRule>();
            //    _rules.Add(new QL.TypeCheckingRules.DuplicateLabelsRule());
            //    _rules.Add(new QL.TypeCheckingRules.ReferenceUndefinedQuestionsRule());
            //    _rules.Add(new QL.TypeCheckingRules.DuplicateQuestionDeclarationsMustBeOfSameTypeRule());
            //    _rules.Add(new QL.TypeCheckingRules.ExpressionMustBeOfExpectedTypeRule());
            //    _rules.Add(new QL.TypeCheckingRules.OperantsMustBeOfValidTypeToOperatorsRule());
            //    _rules.Add(new QL.TypeCheckingRules.CyclicDependencyRule());

            //    var _checker = new QL.TypeChecking.TypeChecker(_rules);
            //    _messages.AddRange(_checker.getMessages(_parseTree));
            //}

            //txtCheckerMessages.Text = String.Join(Environment.NewLine, _messages.Select(_m => _m.ToString()).ToArray());

        }
    }
}
