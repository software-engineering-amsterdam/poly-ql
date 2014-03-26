using System;
using System.IO;
using System.Reflection;
using System.Windows;
using System.Windows.Documents;
using System.Windows.Media;
using Algebra.Core.GrammarParser;
using Algebra.Core.Helpers;
using Algebra.QL.Core.Grammar;
using Algebra.QL.Extensions.Grammar;
using Algebra.QL.Form;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Stmnt;
using Algebra.QL.Form.Type;
using Algebra.QL.Print;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Stmnt;
using Algebra.QL.Print.Type;
using Algebra.QL.TypeCheck;
using Algebra.QL.TypeCheck.Expr;
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
        private static readonly string PathToTestFiles = Path.GetFullPath(@"..\..\..\..\..\TestFiles\");
        private const string DefaultFileName = "QL_Test.txt";

        private readonly Parser Parser;

        public MainWindow()
        {
            InitializeComponent();

            //Parser = GetBasicParser<ITypeCheckExpr, ITypeCheckStmnt, ITypeCheckType, TypeCheckFactory>(new TypeCheckFactory());
            //Parser = GetExtendedParser<ITypeCheckExpr, ITypeCheckStmnt, ITypeCheckType, ExtTypeCheckFactory>(new ExtTypeCheckFactory());

            //Parser = GetExtendedParser<Tuple<ITypeCheckExpr, IPrintExpr>, Tuple<ITypeCheckStmnt, IPrintStmnt>,
            //    Tuple<ITypeCheckType, IPrintType>, TypeCheckPrintFactory>(new TypeCheckPrintFactory());

            Parser = GetExtendedParser<IPair<IPair<ITypeCheckStmnt, IPrintStmnt>, IFormStmnt>,
                IPair<IPair<ITypeCheckExpr, IPrintExpr>, IFormExpr>,
                IPair<IPair<ITypeCheckType, IPrintType>, IFormType>,
                TypeCheckPrintFormFactory>(new TypeCheckPrintFormFactory());

            Parser.OnReduction += OnReduction;
            Parser.OnCompletion += OnCompletion;
            Parser.OnGroupError += OnGroupError;
            Parser.OnInternalError += OnInternalError;
            Parser.OnNotLoadedError += OnNotLoadedError;
            Parser.OnLexicalError += OnLexicalError;
            Parser.OnSyntaxError += OnSyntaxError;
        }

        private static Parser GetBasicParser<S, E, T, F>(F f)
            where F : Algebra.QL.Core.Factory.IStmntFactory<S, E, T>
        {
            var parser = new Parser<S, E, T, F>(f);

            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Core.Grammar.QL_Grammar.egt")));

            return parser;
        }

        private static Parser GetExtendedParser<S, E, T, F>(F f)
            where F : Algebra.QL.Extensions.Factory.IStmntFactory<S, E, T>
        {
            var parser = new ExtParser<S, E, T, F>(f);

            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Extensions.Grammar.QL_Grammar.egt")));

            return parser;
        }

        private void Reset()
        {
            printOutputBlock.Document.Blocks.Clear();
            errorOutputBlock.Document.Blocks.Clear();
            formContainer.Content = null;
        }

        private void RunParser(string code)
        {
            Parser.Parse(code);
        }

        private void PrintMsg(Tuple<int, int> sourceStartPos, Tuple<int, int> sourceEndPos, string msg, Color color)
        {
            TextPointer docStart = customCodeBlock.Document.ContentStart.GetLineStartPosition(0);

            TextPointer start = docStart.GetLineStartPosition(sourceStartPos.Item1);
            for (int i = 0; i <= sourceStartPos.Item2; i++)
            {
                start = start.GetNextInsertionPosition(LogicalDirection.Forward);
            }

            TextPointer end = docStart.GetLineStartPosition(sourceEndPos.Item1);
            for (int i = 0; i <= sourceEndPos.Item2; i++)
            {
                end = end.GetNextInsertionPosition(LogicalDirection.Forward);
            }

            TextRange range = new TextRange(start, end);
            range.ApplyPropertyValue(TextElement.BackgroundProperty, new SolidColorBrush(color));

            PrintMsg(msg, color);
        }

        private void PrintMsg(string msg, Color color)
        {
            errorOutputBlock.Document.Blocks.Add(new Paragraph(new Run(msg)
            {
                Foreground = new SolidColorBrush(color)
            }));
        }

        private void OnReduction(Tuple<int, int> startPos, Tuple<int, int> endPos, object newObj)
        {
            ITypeCheck typeCheckObj = null;

            if (newObj is ITypeCheck)
            {
                typeCheckObj = (ITypeCheck)newObj;
            }
            else if (newObj is IPair<ITypeCheck, IPrint>)
            {
                typeCheckObj = ((IPair<ITypeCheck, IPrint>)newObj).Item1;
            }
            if (newObj is IPair<IPair<ITypeCheck, IPrint>, IForm>)
            {
                typeCheckObj = ((IPair<IPair<ITypeCheck, IPrint>, IForm>)newObj).Item1.Item1;
            }

            if (typeCheckObj != null)
            {
                typeCheckObj.SourceStartPosition = startPos;
                typeCheckObj.SourceEndPosition = endPos;
            }
        }

        private void OnCompletion(object root)
        {
            ErrorManager errMngr = new ErrorManager();
            errMngr.OnError += (msg, sPos, ePos) => PrintMsg(sPos, ePos, msg, Colors.Red);
            errMngr.OnWarning += (msg, sPos, ePos) => PrintMsg(sPos, ePos, msg, Colors.Yellow);

            TypeEnvironment env = new TypeEnvironment(errMngr);

            if (root is ITypeCheckStmnt)
            {
                ((ITypeCheckStmnt)root).TypeCheck(env);
            }
            else if (root is IPair<ITypeCheckStmnt, IPrintStmnt>)
            {
                IPair<ITypeCheckStmnt, IPrintStmnt> combItem = (IPair<ITypeCheckStmnt, IPrintStmnt>)root;
                combItem.Item1.TypeCheck(env);

                printOutputBlock.Document = new FlowDocument(combItem.Item2.BuildDocument());
            }
            else if (root is IPair<IPair<ITypeCheckStmnt, IPrintStmnt>, IFormStmnt>)
            {
                IPair<IPair<ITypeCheckStmnt, IPrintStmnt>, IFormStmnt> combItem = (IPair<IPair<ITypeCheckStmnt, IPrintStmnt>, IFormStmnt>)root;
                combItem.Item1.Item1.TypeCheck(env);

                printOutputBlock.Document = new FlowDocument(combItem.Item1.Item2.BuildDocument());

                if (!errMngr.HasErrors)
                {
                    formContainer.Content = combItem.Item2.BuildForm(new Algebra.QL.Form.Helpers.ValueEnvironment(), new Algebra.QL.Form.Helpers.TypeEnvironment());
                }
            }

            if (!errMngr.HasErrors)
            {
                tabControl.SelectedIndex = 1;
            }
        }

        private void OnGroupError()
        {
            PrintMsg("Unexpected EOF. (Group Error)", Colors.Red);
        }

        private void OnInternalError()
        {
            PrintMsg("INTERNAL ERROR", Colors.Red);
        }

        private void OnNotLoadedError()
        {
            PrintMsg("Grammar file was not loaded", Colors.Red);
        }

        private void OnLexicalError(Tuple<int, int> pos, object token)
        {
            PrintMsg(String.Format("Unknown token '{0}' found on line {1} column {2}", token, pos.Item1, pos.Item2), Colors.Red);
        }

        private void OnSyntaxError(Tuple<int, int> pos, object token, string expected)
        {
            PrintMsg(String.Format("Unexpected token '{0}' on line {1} column {2}. Expected: {3}",
                token, pos.Item1, pos.Item2, expected), Colors.Red);
        }

        private void LoadBtn_Click(object sender, RoutedEventArgs e)
        {
            OpenFileDialog dialog = new OpenFileDialog()
            {
                DefaultExt = "txt",
                InitialDirectory = PathToTestFiles,
                Multiselect = false
            };

            dialog.FileOk += (s, dialogE) =>
            {
                if (!dialogE.Cancel)
                {
                    Reset();

                    string fileContents = new StreamReader(dialog.OpenFile()).ReadToEnd();
                    customCodeBlock.Document.Blocks.Clear();
                    customCodeBlock.AppendText(fileContents);

                    RunParser(fileContents);
                }
            };

            dialog.ShowDialog();
        }

        private void DefaultBtn_Click(object sender, RoutedEventArgs e)
        {
            Reset();

            string defaultFileContents = File.OpenText(PathToTestFiles + DefaultFileName).ReadToEnd();
            customCodeBlock.Document.Blocks.Clear();
            customCodeBlock.AppendText(defaultFileContents);

            RunParser(defaultFileContents);
        }

        private void CustomCodeBtn_Click(object sender, RoutedEventArgs e)
        {
            Reset();

            RunParser(new TextRange(customCodeBlock.Document.ContentStart, customCodeBlock.Document.ContentEnd).Text);
        }

        private void CustomCodeBlock_SelectionChanged(object sender, RoutedEventArgs e)
        {
            TextPointer selStart = customCodeBlock.Selection.Start.GetInsertionPosition(LogicalDirection.Backward);
            TextPointer selStartLine = selStart.GetLineStartPosition(0);

            TextPointer docLine = customCodeBlock.Document.ContentStart.GetLineStartPosition(0);
            int lineNr = 1;
            while (selStartLine.CompareTo(docLine) > 0)
            {
                docLine = docLine.GetLineStartPosition(1);
                lineNr++;
            }
            lnNumber.Content = lineNr;

            TextPointer insPoint = selStartLine.GetNextInsertionPosition(LogicalDirection.Forward);
            int colNr = 1;
            while (selStart.CompareTo(insPoint) > 0)
            {
                insPoint = insPoint.GetNextInsertionPosition(LogicalDirection.Forward);
                colNr++;
            }
            colNumber.Content = colNr;
        }
    }
}
