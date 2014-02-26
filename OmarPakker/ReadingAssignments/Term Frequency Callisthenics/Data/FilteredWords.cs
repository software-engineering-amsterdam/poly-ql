using System.Collections;
using System.Collections.Generic;
using System.Text.RegularExpressions;

namespace Term_Frequency_Callisthenics.Data
{
    public class FilteredWords : IEnumerable<Word>
    {
        private List<Word> _filteredWords;

        public FilteredWords(string input)
        {
            _filteredWords = new List<Word>();

            string filteredInput = Regex.Replace(input, "[^A-Za-z ]", " ");
            filteredInput = Regex.Replace(filteredInput, "[ ]+", " "); //Can't use StringSplitOptions with Split so have to resolve spaces here
            filteredInput = filteredInput.ToLowerInvariant();
            
            foreach (string word in filteredInput.Split(' '))
            {
                _filteredWords.Add(new Word(word));
            }
        }

        public IEnumerator<Word> GetEnumerator()
        {
            return _filteredWords.GetEnumerator();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            return _filteredWords.GetEnumerator();
        }
    }
}
