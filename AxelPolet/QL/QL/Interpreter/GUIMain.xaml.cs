using System.Windows;
using System.Windows.Controls;
using QL.Interpreter.Controls;

namespace QL.Interpreter
{
    /// <summary>
    /// Interaction logic for GUIMain.xaml
    /// </summary>
    public partial class GUIMain : Window
    {
        private readonly GUIQuestionnaire _guiQuestionnaire;

        public GUIMain(GUIQuestionnaire guiQuestionnaire)
        {
            _guiQuestionnaire = guiQuestionnaire;
            InitializeComponent();
        }

        public void Initialize()
        {
            CnvWrapper.Children.Add(_guiQuestionnaire);
            //_guiQuestionnaire.Render();
        }
    }
}
