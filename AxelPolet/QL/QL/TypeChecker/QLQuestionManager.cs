using System.Collections.Generic;

namespace QL.TypeChecker
{
    public class QLQuestionManager
    {
        private List<string> _labels;
        
        public QLQuestionManager()
        {
            _labels = new List<string>();
        }

        public void AddId(string label)
        {
            _labels.Add(label);
        }

        public bool LabelExists(string label)
        {
            return _labels.Contains(label);
        }
    }
}
