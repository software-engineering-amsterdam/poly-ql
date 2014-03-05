using System;
using System.Drawing;
using System.Linq;
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
            txtMessages.Clear();
            pnlErrors.Controls.Clear();
            
            QLController controller = new QLController();
            Questionnaire AST = controller.Run(txtInput.Text);

            foreach (string lexerError in controller.LexerErrors)
                WriteError(lexerError);

            foreach (string parserError in controller.ParserErrors)
                WriteError(parserError);

            QLTypeChecker typeChecker = controller.TypeChecker;

            int yPos = 0;

            foreach (QLTypeError typeError in typeChecker.TypeErrors.OrderBy((te) => te.IsWarning))
            {
                string error = string.Format("{5} QLTypeChecker: {0} {1}" +
                                             "<At token '{2}' on line {3}, column {4}>",
                    typeError.Message, Environment.NewLine,
                    typeError.TokenInfo.TokenText,
                    typeError.TokenInfo.TokenLine,
                    typeError.TokenInfo.TokenColumn,
                    typeError.IsWarning ? "(Warning)" : "(Error)");

                pnlErrors.Controls.Add(new Label{Location = new Point(0, yPos), Text = error, ForeColor = Color.White, BackColor = typeError.IsWarning ? Color.Orange : Color.Red, Width = pnlErrors.Width, Height = 30});
                yPos += 35;
            }


            txtMessages.Text += string.Format(@"{0}{0} Generated parse tree: 
                                              {0} {1}"
                    , Environment.NewLine
                    , controller.GetParseTreeString());
        }
            
        public void WriteError(string error)
        {
            txtMessages.Text += Environment.NewLine + error;
        }
    }
}
