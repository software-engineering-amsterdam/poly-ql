using QL.Interpreter.Controls;
using QL.QLClasses.Expressions;

namespace QL.Interpreter
{
    public class QLGuiBuilder
    {
        private readonly GUIQuestionnaire _guiQuestionnaire;
        
        private ExpressionBase _currentShowCondition;
        private ExpressionBase _currentHideCondition;

        public QLGuiBuilder()
        {
            _guiQuestionnaire = new GUIQuestionnaire();
        }

        public void AppendQuestion(GUIQuestion guiQuestion)
        {
            //callback for refreshing entire questionnaire
            guiQuestion.OnChanged = _guiQuestionnaire.Refresh;

            if (_currentShowCondition != null)
                guiQuestion.ShowCondition = _currentShowCondition;

            if (_currentHideCondition != null)
                guiQuestion.HideCondition = _currentHideCondition;

            _guiQuestionnaire.AddQuestion(guiQuestion);
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

        public GUIQuestionnaire GetGUI()
        {
            return _guiQuestionnaire;
        }
    }
}
