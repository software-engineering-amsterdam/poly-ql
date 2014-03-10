using QL.Interpreter.Controls;
using QL.QLClasses;

namespace QL.Interpreter
{
    public class QLBuilder
    {
        private Questionnaire _ast;
        private GUIQuestionnaire _gui;

        public QLBuilder(Questionnaire AST)
        {
            _ast = AST;
        }

        public void Run()
        {
            _gui = new GUIQuestionnaire();
            _ast.Build(_gui);

            GUIMain main = new GUIMain(_gui);
            main.Initialize();
            main.ShowDialog();
        }
    }
}
