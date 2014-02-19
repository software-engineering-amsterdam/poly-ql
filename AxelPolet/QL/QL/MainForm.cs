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

using QL.Components;

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
            Questionnaire q = parser.theQuestionnaire;
            //if (parser.NumberOfSyntaxErrors > 0)
            //    txtOutput.Text += string.Format("Parser errors found: {0}", parser.NumberOfSyntaxErrors);

            //QLVisitor visitor = new QLVisitor();
            //visitor.Visit(tree);

            txtOutput.Text += string.Format(@"{0}{0} Generated parse tree: 
                                              {0} {1}
                                              {0} {2}
                                              {0} {3}"
                                                , Environment.NewLine
                                                , tree.ToStringTree(parser)
                                                , q.ID
                                                , q.Title);
                                                /*, visitor.Visit(tree)*/
        }
            
        public void WriteError(string error)
        {
            txtOutput.Text += Environment.NewLine + error;
        }

    }
}
