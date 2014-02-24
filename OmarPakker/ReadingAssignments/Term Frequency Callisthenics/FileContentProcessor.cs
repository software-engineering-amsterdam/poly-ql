using System.Collections.Generic;
using Term_Frequency_Callisthenics.Data;

namespace Term_Frequency_Callisthenics
{
    public class FileContentProcessor
    {
        private readonly List<Word> _words;

        public FileContentProcessor(string fileContent)
        {
            _words = new List<Word>();

            FilteredWords filteredWords = new FilteredWords(fileContent);
            StripStopWords(filteredWords);
        }

        private void StripStopWords(IEnumerable<Word> words)
        {
            IEnumerator<Word> enumerator = words.GetEnumerator();
            while (enumerator.MoveNext())
            {
                HandleWord(enumerator.Current);
            }
        }

        private void HandleWord(Word word)
        {
            bool isStopWord = StopWordManager.IsStopWord(word);
            bool lengthGreaterThanOne = word.IsLongerThanOne();

            if (!isStopWord && lengthGreaterThanOne)
            {
                _words.Add(word);
            }
        }

        public IEnumerable<KeyValuePair<Word, OccurenceCount>> ProcessWords()
        {
            OccurencesManager occurencesManager = new OccurencesManager();
            return occurencesManager.GetWordOccurences(_words);
        }
    }
}
