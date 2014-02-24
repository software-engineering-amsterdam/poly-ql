using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Term_Frequency
{
	public class TermFrequency
	{
		private static readonly HashSet<string> StopWords
			= new HashSet<string>(File.OpenText("../../../Input/stop_words.txt").ReadToEnd().Split(','));

		public TermFrequency()
		{

		}

		public IEnumerable<string> ToFilteredWords(string input)
		{
			return new String(input.Where(c => Char.IsLetter(c) || Char.IsWhiteSpace(c)).ToArray())
				.ToLowerInvariant().Split(new[] { ' ', '\r', '\n' }, StringSplitOptions.RemoveEmptyEntries);
		}

        public IEnumerable<string> RemoveStopWordsFromList(IEnumerable<string> words)
        {
            return words.Where(w => !StopWords.Contains(w));
        }

        public IEnumerable<KeyValuePair<string, int>> CountWordOccurences(string input, int maxEntries)
        {
            return CountWordOccurences(input).Take(maxEntries);
        }

        public IEnumerable<KeyValuePair<string, int>> CountWordOccurences(string input)
        {
            Dictionary<string, int> entries = new Dictionary<string, int>();

            foreach (string word in RemoveStopWordsFromList(ToFilteredWords(input)))
            {
                if (!entries.ContainsKey(word))
                {
                    entries.Add(word, 0);
                }
                entries[word]++;
            }

            return entries.OrderByDescending(kv => kv.Value);
        }
	}
}
