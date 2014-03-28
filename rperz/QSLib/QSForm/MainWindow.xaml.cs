using System.Windows;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using QSLib;
using QSLib.Visitors;
namespace QSForm
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            tbInput.Text = "form \r\n{ \r\n\"Dit is een vraag \" bAntwoord : Boolean \r\nif(bAntwoord) \r\n{ \r\n\"Deze vraag moet ook gesteld\" bTest : Boolean \r\n} \r\n}";
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            AntlrInputStream stream = new AntlrInputStream(tbInput.Text);
            QSLexer lex = new QSLexer(stream);
            CommonTokenStream tokens = new CommonTokenStream(lex);
            QSParser parser = new QSParser(tokens);
            IParseTree tree = parser.form();
            MyListener listener = new MyListener(parser);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.Walk(listener, tree);
            IVisitor check = TypeChecker.StartVisit(listener.Root);

            if (check.Result)
            {
                GUIBuilder builder = GUIBuilder.BuildGUI(listener.Root);
                System.Windows.Window wind = new Window();
                wind.Width = 500;
                wind.Content = builder.GetResult();
                wind.Show();
            }
            else
                tbOutput.Text = check.Output.ToString();
        }

    }
}
