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
using QSLib;
using QSLib.AST.Expressions.Literals;
using QSLib.AST.Statements;
using QSLib.AST.Expressions.Unary.Identifiers;
namespace ControlTest
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            Question q = new Question(new QSString("Dit is een testvraag?", 1), new Identifier("TestNaam", 1), 1);
            this.userControl.Children.Add(new QuestionControl());
        }
    }
}
