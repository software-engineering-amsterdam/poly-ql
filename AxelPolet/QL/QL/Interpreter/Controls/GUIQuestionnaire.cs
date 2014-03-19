using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;

namespace QL.Interpreter.Controls
{
    public class GUIQuestionnaire : StackPanel
    {
        public GUIQuestionnaire()
        {
            Width = 700;
            Margin = new Thickness(0, 20, 0, 20);
        }

        public void AddQuestion(GUIQuestion guiQuestion)
        {
            Children.Add(guiQuestion);
            guiQuestion.Render();
        }

        public void Refresh()
        {
            foreach (GUIQuestion guiQuestion in Children)
            {
                guiQuestion.Refresh();
                guiQuestion.Render();
            }
        }
    }
}
