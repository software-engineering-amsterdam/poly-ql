using System.Collections.Generic;
using QL.Interpreter.Controls;
using QL.QLClasses.Expressions;

namespace QL.Interpreter
{
    public class QLGuiBuilder
    {
        private readonly GUIQuestionnaire _guiQuestionnaire;
        
        private ExpressionBase _currentShowCondition;
        private List<ExpressionBase> _currentHideConditions;

        public QLGuiBuilder()
        {
            _guiQuestionnaire = new GUIQuestionnaire();
            _currentHideConditions = new List<ExpressionBase>();
        }

        public void BuildQuestion(QLMemory memory, string name, string label, bool isComputed = false)
        {
            //callback for refreshing entire questionnaire on input change
            GUIQuestion guiQuestion = new GUIQuestion(memory, name, label, isComputed, _currentShowCondition, _guiQuestionnaire.Refresh);
             
            //set show/hide conditions            
            _currentHideConditions.ForEach(guiQuestion.AppendHideCondition);

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

        public void AppendHideCondition(ExpressionBase condition)
        {
            _currentHideConditions.Add(condition);
        }

        public void RemoveHideConditions()
        {
            _currentHideConditions.Clear();
        }

        public GUIQuestionnaire GetGUI()
        {
            return _guiQuestionnaire;
        }
    }
}
