using System.Collections.Generic;
using System.Linq;
using Term_Frequency_Callisthenics.Data;

namespace Term_Frequency_Callisthenics
{
    public class OccurencesManager
    {
        private Dictionary<Word, OccurenceCount> _occurences;

        public OccurencesManager()
        {
            _occurences = new Dictionary<Word, OccurenceCount>();
        }

        private OccurenceCount SortKeySelector(KeyValuePair<Word, OccurenceCount> keyValuePair)
        {
            return keyValuePair.Value;
        }

        private void ProcessWord(Word word)
        {
            if (!_occurences.ContainsKey(word))
            {
                _occurences.Add(word, new OccurenceCount());
            }
            _occurences[word].Increment();
        }

        public IEnumerable<KeyValuePair<Word, OccurenceCount>> GetWordOccurences(IEnumerable<Word> words)
        {
            foreach (Word word in words)
            {
                ProcessWord(word);
            }

            return _occurences.OrderByDescending(SortKeySelector);
        }
    }
}
