using System;
using System.IO;
using System.Reflection;
using System.Windows;
using System.Windows.Documents;
using System.Windows.Media;
using Algebra.Core.GrammarParser;
using Algebra.QL.Core.Grammar;
using Algebra.QL.Extensions.Factory;
using Algebra.QL.Extensions.Grammar;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Stmnt;
using Algebra.QL.Form.Type;
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
        private readonly Parser Parser;

        public MainWindow()
        {
            InitializeComponent();

            //Parser = GetBasicParser<ITypeCheckExpr, ITypeCheckStmnt, ITypeCheckType, TypeCheckFactory>(new TypeCheckFactory());
            //Parser = GetExtendedParser<ITypeCheckExpr, ITypeCheckStmnt, ITypeCheckType, ExtTypeCheckFactory>(new ExtTypeCheckFactory());

            //Parser = GetExtendedParser<Tuple<ITypeCheckExpr, IPrintExpr>, Tuple<ITypeCheckStmnt, IPrintStmnt>,
            //    Tuple<ITypeCheckType, IPrintType>, TypeCheckPrintFactory>(new TypeCheckPrintFactory());

            Parser = GetExtendedParser<Tuple<Tuple<ITypeCheckExpr, IPrintExpr>, IFormExpr>,
                Tuple<Tuple<ITypeCheckStmnt, IPrintStmnt>, IFormStmnt>,
                Tuple<Tuple<ITypeCheckType, IPrintType>, IFormType>,
                TypeCheckPrintFormFactory>(new TypeCheckPrintFormFactory());

            Parser.OnReduction += OnReduction;
            Parser.OnCompletion += OnCompletion;
            Parser.OnGroupError += OnGroupError;
            Parser.OnInternalError += OnInternalError;
            Parser.OnNotLoadedError += OnNotLoadedError;
            Parser.OnLexicalError += OnLexicalError;
            Parser.OnSyntaxError += OnSyntaxError;
        }

        private static Parser GetBasicParser<E, S, T, F>(F f)
            where F : Algebra.QL.Core.Factory.IFactory<E, S, T>
        {
            var parser = new Parser<E, S, T, F>(f);

            Assembly a = parser.GetType().Assembly;
            parser.LoadGrammar(new BinaryReader(a.GetManifestResourceStream("Algebra.QL.Core.Grammar.QL_Grammar.egt")));

            return parser;
        }

        private static Parser GetExtendedParser<E, S, T, F>(F f)
            where F : IExtFactory<E, S, T>
        {
            var parser = new ExtParser<E, S, T, F>(f);

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

        private void PrintError(Tuple<int, int> sourceStartPos, Tuple<int, int> sourceEndPos, string msg, bool error)
        {
            TextPointer docStart = customCodeBlock.Document.ContentStart.GetLineStartPosition(0);

            TextPointer start = docStart.GetLineStartPosition(sourceStartPos.Item1);
            for(int i = 0; i <= sourceStartPos.Item2; i++)
            {
                start = start.GetNextInsertionPosition(LogicalDirection.Forward);
            }

            TextPointer end = docStart.GetLineStartPosition(sourceEndPos.Item1);
            for (int i = 0; i <= sourceEndPos.Item2; i++)
            {
                end = end.GetNextInsertionPosition(LogicalDirection.Forward);
            }

            TextRange range = new TextRange(start, end);
            range.ApplyPropertyValue(TextElement.BackgroundProperty, new SolidColorBrush(error ? Colors.Red : Colors.Yellow));

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
            else if (newObj is Tuple<ITypeCheckType, IPrintType>)
            {
                typeCheckObj = ((Tuple<ITypeCheckType, IPrintType>)newObj).Item1;
            }
            else if (newObj is Tuple<ITypeCheckExpr, IPrintExpr>)
            {
                typeCheckObj = ((Tuple<ITypeCheckExpr, IPrintExpr>)newObj).Item1;
            }
            else if (newObj is Tuple<ITypeCheckStmnt, IPrintStmnt>)
            {
                typeCheckObj = ((Tuple<ITypeCheckStmnt, IPrintStmnt>)newObj).Item1;
            }
            else if (newObj is Tuple<Tuple<ITypeCheckType, IPrintType>, IFormType>)
            {
                typeCheckObj = ((Tuple<Tuple<ITypeCheckType, IPrintType>, IFormType>)newObj).Item1.Item1;
            }
            else if (newObj is Tuple<Tuple<ITypeCheckExpr, IPrintExpr>, IFormExpr>)
            {
                typeCheckObj = ((Tuple<Tuple<ITypeCheckExpr, IPrintExpr>, IFormExpr>)newObj).Item1.Item1;
            }
            else if (newObj is Tuple<Tuple<ITypeCheckStmnt, IPrintStmnt>, IFormStmnt>)
            {
                typeCheckObj = ((Tuple<Tuple<ITypeCheckStmnt, IPrintStmnt>, IFormStmnt>)newObj).Item1.Item1;
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
            else if (root is Tuple<Tuple<ITypeCheckStmnt, IPrintStmnt>, IFormStmnt>)
            {
                Tuple<Tuple<ITypeCheckStmnt, IPrintStmnt>, IFormStmnt> combItem = (Tuple<Tuple<ITypeCheckStmnt, IPrintStmnt>, IFormStmnt>)root;
                combItem.Item1.Item1.TypeCheck(env, errRep);

                printOutputBlock.Document = new FlowDocument(combItem.Item1.Item2.BuildDocument());

                if (!errRep.HasErrors)
                {
                    formContainer.Content = combItem.Item2.BuildForm();
                }
            }

            if(!errRep.HasErrors)
            {
                tabControl.SelectedIndex = 1;
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

            string defaultFileContents = File.OpenText(@"..\..\..\..\..\Grammar\QL_Test.txt").ReadToEnd();
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
