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
using System.Reflection;

using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

using QL.Components;
using QL.Components.Statements;
using QL.Components.Conditions;

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
            Questionnaire qst = parser.theQuestionnaire;

            foreach (StatementBase statement in qst.Body)
            {
                CheckStatement(statement);
            }
            
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
                                                , qst.ID
                                                , qst.Title);
                                                /*, visitor.Visit(tree)*/
        }
            
        public void WriteError(string error)
        {
            txtOutput.Text += Environment.NewLine + error;
        }

        public void CheckStatement(StatementBase statement)
        {
            if (statement is ITypeChecker)
                if (!(statement as ITypeChecker).CheckType())
                    WriteError(string.Format("error at {0}, {1}", statement.TokenLine, statement.TokenColumn));
            
            IEnumerable<PropertyInfo> props = statement.GetType().GetProperties(BindingFlags.DeclaredOnly | BindingFlags.Instance | BindingFlags.Public);
            foreach(PropertyInfo pInfo in props)
                if (pInfo.PropertyType.GetInterfaces().Contains(typeof(IExpression)))
                    CheckExpression(pInfo.GetValue(statement) as ExpressionBase);
            
            if(statement is StatementIf)
                foreach(StatementBase innerStatement in (statement as StatementIf).Body)
                    CheckStatement(innerStatement);
        }

        public void CheckExpression(ExpressionBase expression)
        {
            if (expression is ITypeChecker)
                if (!(expression as ITypeChecker).CheckType())
                    WriteError(string.Format("error at {0}, {1}", expression.TokenLine, expression.TokenColumn));

            IEnumerable<PropertyInfo> props = expression.GetType().GetProperties(BindingFlags.DeclaredOnly | BindingFlags.Instance | BindingFlags.Public);
            foreach (PropertyInfo pInfo in props)
                if (pInfo.GetType().IsAssignableFrom(typeof(IExpression)))
                    CheckExpression(pInfo.GetValue(expression) as ExpressionBase);
        }
    }
}
