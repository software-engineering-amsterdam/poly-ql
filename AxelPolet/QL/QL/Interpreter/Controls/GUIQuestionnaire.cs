using System.Collections.Generic;
using System.Windows.Controls;
using QL.QLClasses.Expressions;

namespace QL.Interpreter.Controls
{
    public class GUIQuestionnaire : StackPanel
    {
        private readonly List<GUIQuestion> _questions;
        
        private ExpressionBase _currentShowCondition;
        private ExpressionBase _currentHideCondition;

        public GUIQuestionnaire()
        {
            _questions = new List<GUIQuestion>();
            
            Width = 500;
        }

        public void AppendQuestion(GUIQuestion guiQuestion)
        {
            guiQuestion.OnChanged = Refresh;

            if (_currentShowCondition != null)
                guiQuestion.ShowCondition = _currentShowCondition;

            if (_currentHideCondition != null)
                guiQuestion.HideCondition = _currentHideCondition;

            _questions.Add(guiQuestion);
        }

        public void SetShowCondition(ExpressionBase condition)
        {
            _currentShowCondition = condition;
        }

        public void RemoveShowCondition()
        {
            _currentShowCondition = null;
        }

        public void SetHideCondition(ExpressionBase condition)
        {
            _currentHideCondition = condition;
        }

        public void RemoveHideCondition()
        {
            _currentHideCondition = null;
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
