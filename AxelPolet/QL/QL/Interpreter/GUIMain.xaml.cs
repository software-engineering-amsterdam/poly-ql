using System.Windows;
using QL.Interpreter.Controls;

namespace QL.Interpreter
{
    /// <summary>
    /// Interaction logic for GUIMain.xaml
    /// </summary>
    public partial class GUIMain : Window
    {
        private GUIQuestionnaire _gui;

        public GUIMain(GUIQuestionnaire gui)
        {
            _gui = gui;
            InitializeComponent();
        }

        public void Initialize()
        {
            _gui.Render();
            CnvWrapper.Children.Add(_gui);
        }
    }
}
