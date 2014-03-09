using System.Collections.Generic;
using System.Linq;
using System.Windows.Controls;
using QL.QLClasses.Expressions;

namespace QL.Interpreter.Controls
{
    public class GUIQuestionnaire : StackPanel
    {
        private readonly List<GUIQuestion> _questions;
        private readonly List<ExpressionBase> _preConditions;
        private ExpressionBase _currentCondition;

        public GUIQuestionnaire()
        {
            _questions = new List<GUIQuestion>();
            _preConditions = new List<ExpressionBase>();
            
            Width = 500;
        }

        public void AppendQuestion(GUIQuestion guiQuestion)
        {
            guiQuestion.OnChanged = Refresh;
            
            if (_currentCondition != null)
                guiQuestion.ShowCondition = _currentCondition;

            if (_currentCondition == null && _preConditions.Any())
                guiQuestion.DoNotShowConditions = _preConditions;

            _questions.Add(guiQuestion);
        }

        public void SetCondition(ExpressionBase condition)
        {
            _currentCondition = condition;
        }

        public void RemoveCondition(bool isFinal)
        {
            if(!isFinal)
                _preConditions.Add(_currentCondition);
            else
                _preConditions.Clear();

            _currentCondition = null;
        }

        public void Render()
        {
            foreach (GUIQuestion gq in _questions)
            {
                gq.Render();
                Children.Add(gq);
            }
        }

        public void Refresh()
        {
            foreach (GUIQuestion gq in _questions)
            {
                gq.Refresh();
                gq.Render();
            }
        }
    }
}
