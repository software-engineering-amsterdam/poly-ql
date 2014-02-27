using System;
using System.Collections.Generic;
using System.IO;
using System.Reflection;
using System.Windows;
using System.Windows.Documents;
using System.Windows.Media;
using Algebra.Core.Factory;
using Algebra.Core.GrammarParser;
using Algebra.Core.Tree;
using Algebra.QL.Core.Grammar;
using Algebra.QL.Extensions.Grammar;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Stmnt;
using Algebra.QL.Print.Type;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Factory;
using Algebra.QL.TypeCheck.Helpers;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;
using Microsoft.Win32;
using WPFParser.MergedFactory;

namespace WPFParser
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private readonly AbstractParser Parser;

        public MainWindow()
        {
            InitializeComponent();

            //Parser = GetTypeCheckParser();
            Parser = GetComboParser();

            Parser.OnReduction += OnReduction;
            Parser.OnCompletion += OnCompletion;
            Parser.OnGroupError += OnGroupError;
            Parser.OnInternalError += OnInternalError;
            Parser.OnNotLoadedError += OnNotLoadedError;
            Parser.OnLexicalError += OnLexicalError;
            Parser.OnSyntaxError += OnSyntaxError;
        }

        private AbstractParser GetTypeCheckParser()
        {
            var parser = new QLParser<ITypeCheckExpr, ITypeCheckStmnt, ITypeCheckType, QLTypeCheckFactory>(new QLTypeCheckFactory());

            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Core.Grammar.QL_Grammar.egt")));

            return parser;
        }

        private AbstractParser GetComboParser()
        {
            var parser = new ExtensionsParser<CombinedExpr<ITypeCheckExpr, IPrintExpr>,
                CombinedStmnt<ITypeCheckStmnt, IPrintStmnt>, CombinedType<ITypeCheckType, IPrintType>,
                TypeCheckPrintFactory>(new TypeCheckPrintFactory());

            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Extensions.Grammar.QL_Grammar.egt")));

            parser.OnReduction += OnReduction;
            parser.OnCompletion += OnCompletion;
            parser.OnGroupError += OnGroupError;
            parser.OnInternalError += OnInternalError;
            parser.OnNotLoadedError += OnNotLoadedError;
            parser.OnLexicalError += OnLexicalError;
            parser.OnSyntaxError += OnSyntaxError;

            return parser;
        }

        private void LoadBtn_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog dialog = new OpenFileDialog()
            {
                DefaultExt = "txt",
                InitialDirectory = System.IO.Path.GetFullPath(@"..\..\..\..\..\Grammar\"),
                Multiselect = false
            };

            dialog.FileOk += (s, dialogE) =>
            {
                if (!dialogE.Cancel)
                {
                    ResetTextBoxes();

                    RunParser(new StreamReader(dialog.OpenFile()).ReadToEnd());
                }
            };

            dialog.ShowDialog();
        }

        private void defaultBtn_Click(object sender, RoutedEventArgs e)
        {
            ResetTextBoxes();

            RunParser(File.OpenText(@"..\..\..\..\..\Grammar\QL_Test.txt").ReadToEnd());
        }

        private void customCodeBtn_Click(object sender, RoutedEventArgs e)
        {
            ResetTextBoxes();

            RunParser(new TextRange(customCodeBlock.Document.ContentStart, customCodeBlock.Document.ContentEnd).Text);
            tabControl.SelectedIndex = 0;
        }

        private void ResetTextBoxes()
        {
            printOutputBlock.Document.Blocks.Clear();
            errorOutputBlock.Document.Blocks.Clear();
        }

        private void RunParser(string code)
        {
            Parser.Parse(code);
        }

        private void PrintError(string msg, bool error)
        {
            errorOutputBlock.Document.Blocks.Add(new Paragraph(new Run(msg)
            {
                Foreground = new SolidColorBrush(error ? Colors.Red : Colors.Yellow)
            }));
        }

        private void OnReduction(int line, int column, object newObj)
        {
            if(newObj is INode)
            {
                ((INode)newObj).SourcePosition = new Tuple<int, int>(line, column);
            }
        }

        private void OnCompletion(object root)
        {
            //TODO: WIP rewrite typecheck as a BF/DF traversal combination. Alternatively maybe use iterative deepening depth-first traversal?

            if (root is ITypeCheckStmnt)
            {
                TypeCheckData data = new TypeCheckData();
                data.OnTypeCheckError += PrintError;
                ((ITypeCheckStmnt)root).TypeCheck(new Queue<ITypeCheckStmnt>(), data);
            }
            else if (root is CombinedStmnt<ITypeCheckStmnt, IPrintStmnt>)
            {
                CombinedStmnt<ITypeCheckStmnt, IPrintStmnt> combItem = (CombinedStmnt<ITypeCheckStmnt, IPrintStmnt>)root;

                TypeCheckData data = new TypeCheckData();
                data.OnTypeCheckError += PrintError;
                combItem.Item1.TypeCheck(new Queue<ITypeCheckStmnt>(), data);

                printOutputBlock.Document = new FlowDocument(combItem.Item2.BuildDocument());
            }
        }

        private void OnGroupError()
        {
            PrintError("ERROR: Unexpected EOF. (Group Error)", true);
        }

        private void OnInternalError()
        {
            PrintError("ERROR: INTERNAL ERROR", true);
        }

        private void OnNotLoadedError()
        {
            PrintError("ERROR: Grammar file was not loaded", true);
        }

        private void OnLexicalError(int line, int column, object token)
        {
            PrintError(String.Format("ERROR: Unknown token '{0}' found on line {1} column {2}", token, line, column), true);
        }

        private void OnSyntaxError(int line, int column, object token, string expected)
        {
            PrintError(String.Format("ERROR: Unexpected token '{0}' on line {1} column {2}. Expected: {3}",
                token, line, column, expected), true);
        }
    }
}
