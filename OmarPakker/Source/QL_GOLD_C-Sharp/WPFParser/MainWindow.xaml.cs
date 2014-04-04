using System;
using System.IO;
using System.Windows;
using System.Windows.Documents;
using System.Windows.Media;
using Algebra.Core.Collections;
using Algebra.Core.Environment;
using Algebra.Core.Grammar;
using Algebra.QL.Form;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Stmnt;
using Algebra.QL.Form.Type;
using Algebra.QL.Print;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Stmnt;
using Algebra.QL.Print.Type;
using Algebra.QL.TypeCheck;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;
using Microsoft.Win32;
using WPFParser.ExtensionMethods;
using WPFParser.Helpers;
using WPFParser.MergedFactory;

namespace WPFParser
{
    public partial class MainWindow : Window
    {
        private static readonly string PathToTestFiles = Path.GetFullPath(@"..\..\..\..\..\TestFiles\");
        private const string DefaultFileName = "QL_Test.txt";

        private readonly Parser Parser;

        public MainWindow()
        {
            InitializeComponent();

            Parser = ParserConstructor.GetExtendedParser<IPair<IPair<ITypeCheckStmnt, IPrintStmnt>, IFormStmnt>,
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

        private void Reset()
        {
            codeTextBox.Document.Blocks.Clear();
            printOutputTextBox.Document.Blocks.Clear();
            errorOutputTextBox.Document.Blocks.Clear();
            questionaireContainer.Content = null;
        }

        private void RunParser()
        {
            printOutputTextBox.Document.Blocks.Clear();
            errorOutputTextBox.Document.Blocks.Clear();
            questionaireContainer.Content = null;

            Parser.Parse(new TextRange(codeTextBox.Document.ContentStart, codeTextBox.Document.ContentEnd).Text);
        }

        private void PrintMsg(Tuple<int, int> sourceStartPos, Tuple<int, int> sourceEndPos, string msg, Color color)
        {
            TextRange range = new TextRange(codeTextBox.GetTextPointerForPosition(sourceStartPos), codeTextBox.GetTextPointerForPosition(sourceEndPos));
            range.ApplyPropertyValue(TextElement.BackgroundProperty, new SolidColorBrush(color));

            PrintMsg(msg, color);
        }

        private void PrintMsg(string msg, Color color)
        {
            errorOutputTextBox.Document.Blocks.Add(new Paragraph(new Run(msg)
            {
                Foreground = new SolidColorBrush(color)
            }));
        }

        private void OnReduction(Tuple<int, int> startPos, Tuple<int, int> endPos, object newObj)
        {
            if (newObj is IPair<IPair<ITypeCheck, IPrint>, IForm>)
            {
                ITypeCheck typeCheckObj = ((IPair<IPair<ITypeCheck, IPrint>, IForm>)newObj).Item1.Item1;

                typeCheckObj.SourceStartPosition = startPos;
                typeCheckObj.SourceEndPosition = endPos;
            }
        }

        private void OnCompletion(object root)
        {
            ErrorManager errMngr = new ErrorManager();
            errMngr.ErrorReported += (msg, sPos, ePos) => PrintMsg(sPos, ePos, msg, Colors.Red);
            errMngr.WarningReported += (msg, sPos, ePos) => PrintMsg(sPos, ePos, msg, Colors.Yellow);

            IPair<IPair<ITypeCheckStmnt, IPrintStmnt>, IFormStmnt> combItem = (IPair<IPair<ITypeCheckStmnt, IPrintStmnt>, IFormStmnt>)root;
            combItem.Item1.Item1.TypeCheck(new TypeEnvironment(errMngr));

            if (!errMngr.HasErrors)
            {
                printOutputTextBox.Document = new FlowDocument(combItem.Item1.Item2.BuildDocument(0));
                questionaireContainer.Content = combItem.Item2.BuildForm(new Algebra.QL.Eval.Environment.ValueEnvironment(), new Algebra.QL.Form.Environment.TypeEnvironment());
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
            PrintMsg(new Tuple<int,int>(pos.Item1, pos.Item2 - 1), pos,
                String.Format("Unknown token '{0}' found on line {1} column {2}",
                token, pos.Item1, pos.Item2), Colors.Red);
        }

        private void OnSyntaxError(Tuple<int, int> pos, object token, string expected)
        {
            PrintMsg(new Tuple<int, int>(pos.Item1, pos.Item2 - 1), pos,
                String.Format("Unexpected token '{0}' on line {1} column {2}. Expected: {3}",
                token, pos.Item1, pos.Item2, expected), Colors.Red);
        }

        private void OnLoadButtonClick(object sender, RoutedEventArgs e)
        {
            OpenFileDialog dialog = new OpenFileDialog()
            {
                DefaultExt = ".txt",
                Filter = "Text Files|*.txt",
                InitialDirectory = PathToTestFiles,
                Multiselect = false
            };

            if (dialog.ShowDialog().Value)
            {
                Reset();

                codeTextBox.AppendText(new StreamReader(dialog.OpenFile()).ReadToEnd());
            }
        }

        private void OnDefaultButtonClick(object sender, RoutedEventArgs e)
        {
            Reset();

            codeTextBox.AppendText(File.OpenText(PathToTestFiles + DefaultFileName).ReadToEnd());
        }

        private void OnRunCodeButtonClick(object sender, RoutedEventArgs e)
        {
            RunParser();
        }

        private void OnCodeTextBoxSelectionChanged(object sender, RoutedEventArgs e)
        {
            TextPointer tp = codeTextBox.Selection.Start;
            lnNumber.Content = codeTextBox.GetLineForTextPointer(tp);
            colNumber.Content = codeTextBox.GetColumnForTextPointer(tp);
        }
    }
}
