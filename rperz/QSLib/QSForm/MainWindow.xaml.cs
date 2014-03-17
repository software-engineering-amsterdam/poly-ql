using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using QSLib.Expressions;
using QSLib;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;

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
            TypeChecker check = TypeChecker.CheckTypes(listener.Root);
            tbOutput.Text = check.GetCheckerOutput();

            GUIBuilder builder = GUIBuilder.BuildGUI(listener.Root);
            System.Windows.Window wind = new Window();
            wind.Content = builder.GetResult();
            wind.Show();
        }

    }
}
