using System.Collections.Generic;
using System.Windows.Controls;

namespace QL.Interpreter.Controls
{
    public class GUIQuestionnaire : StackPanel
    {
        private readonly List<GUIQuestion> _questions;

        public GUIQuestionnaire()
        {
            _questions = new List<GUIQuestion>();
            Width = 500;
        }

        public void AddQuestion(GUIQuestion guiQuestion)
        {
            _questions.Add(guiQuestion);
        }

        public void Render()
        {
            foreach (GUIQuestion guiQuestion in _questions)
            {
                guiQuestion.Render();
                Children.Add(guiQuestion);
            }
        }

        public void Refresh()
        {
            foreach (GUIQuestion guiQuestion in _questions)
            {
                guiQuestion.Refresh();
                guiQuestion.Render();
            }
        }
    }
}
