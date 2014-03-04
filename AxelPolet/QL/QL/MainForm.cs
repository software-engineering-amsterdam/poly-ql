using System;
using System.Windows.Forms;
using QL.QLClasses;
using QL.TypeChecker;

namespace QL
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            InitializeComponent();
        }

        private void btnParse_Click(object sender, EventArgs e)
        {
            txtOutput.Clear();

            QLController controller = new QLController();
            controller.Run(txtInput.Text);

            Questionnaire AST = controller.AST;
            
            if (AST == null)
            {
                WriteError("AST is null!!!");
            }
            else
            {
                foreach (string lexerError in controller.LexerErrors)
                    WriteError(lexerError);

                foreach (string parserError in controller.ParserErrors)
                    WriteError(parserError);

                QLTypeChecker typeChecker = controller.TypeChecker;

                foreach (QLTypeError typeError in typeChecker.TypeErrors)
                {
                    WriteError(string.Format("{6} QLTypeChecker: {0} {1}"  +
                            "<At token '{2}' on line {3}, column {4}>{5}", 
                            typeError.Message, Environment.NewLine, 
                            typeError.TokenInfo.TokenText, 
                            typeError.TokenInfo.TokenLine, 
                            typeError.TokenInfo.TokenColumn, 
                            Environment.NewLine,
                            typeError.IsWarning ? "(Warning)" : "(Error)"));
                }
            }

            txtOutput.Text += string.Format(@"{0}{0} Generated parse tree: 
                                              {0} {1}"
                    , Environment.NewLine
                    , controller.GetParseTreeString());
        }
            
        public void WriteError(string error)
        {
            txtOutput.Text += Environment.NewLine + error;
        }
    }
}
