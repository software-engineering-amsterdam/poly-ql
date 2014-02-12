using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

using Antlr4.Runtime;
using Antlr4.Runtime.Tree;


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
            string inputString = txtInput.Text + "^z";
            MemoryStream inputStream = new MemoryStream(Encoding.UTF8.GetBytes(inputString ?? ""));

            AntlrInputStream input = new AntlrInputStream(inputStream);
            QLLexer lexer = new QLLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            QLParser parser = new QLParser(tokens);

            lexer.RemoveErrorListeners();
            parser.RemoveErrorListeners();

            lexer.AddErrorListener(new LexerErrorListener(){OnError = WriteError});
            parser.AddErrorListener(new ParserErrorListener(){OnError = WriteError});

            IParseTree tree = parser.prog();

            if (parser.NumberOfSyntaxErrors > 0)
                txtOutput.Text += string.Format("Parser errors found: {0}", parser.NumberOfSyntaxErrors);

            QLVisitor visitor = new QLVisitor();

            txtOutput.Text += string.Format(@" {0} Generated parse tree: 
                                               {0} {1}
                                               {0} {2}"
                                                , Environment.NewLine
                                                , tree.ToStringTree(parser)
                                                , visitor.Visit(tree));
        }
            
        public void WriteError(string error)
        {
            txtOutput.Text += Environment.NewLine + error;
        }

    }
}
