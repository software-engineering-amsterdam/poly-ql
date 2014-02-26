using System;

using System.Text;
using System.Windows.Forms;
using System.IO;

using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

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
            QLIdentifiers.Reset();
            QLTypeChecker.ClearAdditionalErrors();

            string inputString = txtInput.Text;
            MemoryStream inputStream = new MemoryStream(Encoding.UTF8.GetBytes(inputString ?? ""));

            AntlrInputStream input = new AntlrInputStream(inputStream);
            QLLexer lexer = new QLLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLParser parser = new QLParser(tokens);

            lexer.RemoveErrorListeners();
            parser.RemoveErrorListeners();

            lexer.AddErrorListener(new LexerErrorListener(){OnError = WriteError});
            parser.AddErrorListener(new ParserErrorListener(){OnError = WriteError});

            IParseTree tree = parser.questionnaire();
            Questionnaire AST = parser.theQuestionnaire;

            if (AST == null)
            {
                WriteError("AST is null!!!");

                txtOutput.Text += string.Format(@"{0}{0} Generated parse tree: 
                                              {0} {1}"
                                    , Environment.NewLine
                                    , tree.ToStringTree(parser));
            }
            else
            {
                QLTypeChecker typeChecker = new QLTypeChecker();
                typeChecker.OnError += WriteError;
                typeChecker.Check(AST);

                txtOutput.Text += string.Format(@"{0}{0} Generated parse tree: 
                                              {0} {1}"
                                    , Environment.NewLine
                                    , tree.ToStringTree(parser));
            }
        }
            
        public void WriteError(string error)
        {
            txtOutput.Text += Environment.NewLine + error;
        }
    }
}
