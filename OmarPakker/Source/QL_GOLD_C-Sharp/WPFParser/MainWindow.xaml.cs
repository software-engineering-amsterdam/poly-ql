using System;
using System.IO;
using System.Reflection;
using System.Windows;
using System.Windows.Documents;
using System.Windows.Media;
using Algebra.Core.GrammarParser;
using Algebra.QL.Core.Grammar;
using Algebra.QL.Extensions.Grammar;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Stmnt;
using Algebra.QL.Print.Type;
using Algebra.QL.TypeCheck;
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
        private readonly Parser Parser;

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

        private Parser GetTypeCheckParser()
        {
            var parser = new QLParser<ITypeCheckExpr, ITypeCheckStmnt, ITypeCheckType, QLTypeCheckFactory>(new QLTypeCheckFactory());

            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Core.Grammar.QL_Grammar.egt")));

            return parser;
        }

        private Parser GetComboParser()
        {
            var parser = new ExtensionsParser<Tuple<ITypeCheckExpr, IPrintExpr>,
                Tuple<ITypeCheckStmnt, IPrintStmnt>, Tuple<ITypeCheckType, IPrintType>,
                TypeCheckPrintFactory>(new TypeCheckPrintFactory());

            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Extensions.Grammar.QL_Grammar.egt")));

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

                    string fileContents = new StreamReader(dialog.OpenFile()).ReadToEnd();
                    customCodeBlock.Document.Blocks.Clear();
                    customCodeBlock.AppendText(fileContents);

                    RunParser(fileContents);
                }
            };

            dialog.ShowDialog();
        }

        private void defaultBtn_Click(object sender, RoutedEventArgs e)
        {
            ResetTextBoxes();

            string defaultFileContents = File.OpenText(@"..\..\..\..\..\Grammar\QL_Test.txt").ReadToEnd();
            customCodeBlock.Document.Blocks.Clear();
            customCodeBlock.AppendText(defaultFileContents);

            RunParser(defaultFileContents);
        }

        private void customCodeBtn_Click(object sender, RoutedEventArgs e)
        {
            ResetTextBoxes();

            RunParser(new TextRange(customCodeBlock.Document.ContentStart, customCodeBlock.Document.ContentEnd).Text);
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

        private void PrintError(Tuple<int, int> sourceStartPos, Tuple<int, int> sourceEndPos, string msg, bool error)
        {
            //TextPointer docStart = customCodeBlock.Document.ContentStart.GetLineStartPosition(0);

            //TextPointer start = docStart.GetLineStartPosition(sourceStartPos.Item1 - 1).GetPositionAtOffset(sourceStartPos.Item2);
            //TextPointer end = docStart.GetLineStartPosition(sourceEndPos.Item1 - 1).GetPositionAtOffset(sourceEndPos.Item2);

            //customCodeBlock.Selection.Select(start, end);
            //customCodeBlock.Selection.ApplyPropertyValue(TextElement.BackgroundProperty, new SolidColorBrush(Colors.Red));

            PrintError(msg, error);
        }

        private void PrintError(string msg, bool error)
        {
            errorOutputBlock.Document.Blocks.Add(new Paragraph(new Run(msg)
            {
                Foreground = new SolidColorBrush(error ? Colors.Red : Colors.Yellow)
            }));
        }

        private void OnReduction(Tuple<int, int> startPos, Tuple<int, int> endPos, object newObj)
        {
            ITypeCheck typeCheckObj = null;

            if (newObj is ITypeCheck)
            {
                typeCheckObj = (ITypeCheck)newObj;
            }
            else if (newObj is Tuple<ITypeCheckExpr, IPrintExpr>)
            {
                typeCheckObj = ((Tuple<ITypeCheckExpr, IPrintExpr>)newObj).Item1;
            }
            else if (newObj is Tuple<ITypeCheckStmnt, IPrintStmnt>)
            {
                typeCheckObj = ((Tuple<ITypeCheckStmnt, IPrintStmnt>)newObj).Item1;
            }

            if(typeCheckObj != null)
            {
                typeCheckObj.SourceStartPosition = startPos;
                typeCheckObj.SourceEndPosition = endPos;
            }
        }

        private void OnCompletion(object root)
        {
            ErrorReporter errRep = new ErrorReporter();
            errRep.OnTypeCheckError += PrintError;

            TypeEnvironment env = new TypeEnvironment();

            if (root is ITypeCheckStmnt)
            {
                ((ITypeCheckStmnt)root).TypeCheck(env, errRep);
            }
            else if (root is Tuple<ITypeCheckStmnt, IPrintStmnt>)
            {
                Tuple<ITypeCheckStmnt, IPrintStmnt> combItem = (Tuple<ITypeCheckStmnt, IPrintStmnt>)root;
                combItem.Item1.TypeCheck(env, errRep);

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

        private void OnLexicalError(Tuple<int, int> pos, object token)
        {
            PrintError(String.Format("ERROR: Unknown token '{0}' found on line {1} column {2}", token, pos.Item1, pos.Item2), true);
        }

        private void OnSyntaxError(Tuple<int, int> pos, object token, string expected)
        {
            PrintError(String.Format("ERROR: Unexpected token '{0}' on line {1} column {2}. Expected: {3}",
                token, pos.Item1, pos.Item2, expected), true);
        }
    }
}
