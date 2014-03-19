using System;
using System.Drawing;
using System.Linq;
using System.Windows.Forms;
using QL.TypeChecker;

namespace QL
{
    public partial class MainForm : Form
    {
        private QLController _qlController;
        private int _errorYPos;

        public MainForm()
        {
            InitializeComponent();
        }

        private void btnParse_Click(object sender, EventArgs e)
        {
            txtMessages.Clear();
            pnlErrors.Controls.Clear();

            _qlController = new QLController();
            _errorYPos = 0;
            
            //build AST + check types
            _qlController.BuildAST(txtInput.Text);

            foreach (string lexerError in _qlController.LexerErrors)
                WriteMessage(lexerError);

            if(_qlController.LexerErrors.Any())
                WriteErrorLabel("Lexer errors occurred, see messages");

            foreach (string parserError in _qlController.ParserErrors)
                WriteMessage(parserError);

            if(_qlController.ParserErrors.Any())
                WriteErrorLabel("Parser errors occurred, see messages");

            //get type errors
            QLTypeChecker typeChecker = _qlController.TypeChecker;
            foreach (QLTypeError typeError in typeChecker.TypeErrors.OrderBy((te) => te.IsWarning))
            {
                string error = string.Format("{5} QLTypeChecker: {0} {1}" +
                                             "<At token '{2}' on line {3}, column {4}>",
                    typeError.Message, Environment.NewLine,
                    typeError.TokenInfo.TokenText,
                    typeError.TokenInfo.TokenLine,
                    typeError.TokenInfo.TokenColumn,
                    typeError.IsWarning ? "(Warning)" : "(Error)");

                WriteErrorLabel(error, typeError.IsWarning);
            }
            
            WriteMessage(string.Format(@"Generated parse tree: 
                                              {0} {1}"
                    , Environment.NewLine
                    , _qlController.GetParseTreeString()));

            //check if generate is possible
            if (_qlController.LexerErrors.Any() || _qlController.ParserErrors.Any() || typeChecker.TypeErrors.Any((te) => !te.IsWarning))
                lblSuccess.Visible = btnGenerate.Enabled = false;
            else
                lblSuccess.Visible = btnGenerate.Enabled = true;
        }
            
        public void WriteErrorLabel(string error, bool isWarning = false)
        {
            pnlErrors.Controls.Add(new Label { Location = new Point(0, _errorYPos), Text = error, ForeColor = Color.White, BackColor = isWarning ? Color.Orange : Color.Red, Width = pnlErrors.Width, Height = 30 });
            _errorYPos += 35;
        }

        public void WriteMessage(string message)
        {
            txtMessages.Text += Environment.NewLine + message;
        }

        private void btnGenerate_Click(object sender, EventArgs e)
        {
            _qlController.GenerateGUI();
        }
    }
}
