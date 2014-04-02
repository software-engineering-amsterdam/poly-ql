using System.Windows;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using QSLib;
using QSLib.Visitors;
using System.IO;
namespace QSForm
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private string[] _testExamples;
        private int _exampleNumber = 0;
        public MainWindow()
        {
            InitializeComponent();
            this.ReadFile(@"c:\school\poly-ql\rperz\QSLib\testcode.txt");
            this.Paste_Click(null, null);
        }

        private void Parse_Click(object sender, RoutedEventArgs e)
        {
            AntlrInputStream stream = new AntlrInputStream(this._tbInput.Text);
            QSLexer lex = new QSLexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lex);
            QSParser parser = new QSParser(tokens);
            IParseTree tree = parser.form();
            MyListener listener = new MyListener(parser);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.Walk(listener, tree);
            IVisitor<bool> check = TypeChecker.StartVisit(listener.Root);

            if (check.Result)
            {
                GUIBuilder builder = GUIBuilder.BuildGUI(listener.Root);
                System.Windows.Window wind = new Window();
                wind.Width = 500;
                wind.Content = builder.Result;
                wind.Show();
            }
            else
                this._tbOutput.Text = ((TypeChecker)check).Output.ToString();
        }

        private void Paste_Click(object sender, RoutedEventArgs e)
        {
            this._tbInput.Text = _testExamples[_exampleNumber];
            this._exampleNumber +=1;
            if (this._exampleNumber >= this._testExamples.Length)
                this._pasteButton.IsEnabled = false;
        }

        private void ReadFile(string path)
        {
            using (StreamReader read = new StreamReader(path))
            {
                string textInFile = read.ReadToEnd();
                this._testExamples = textInFile.Split('@');
            }
        }
    }
}
