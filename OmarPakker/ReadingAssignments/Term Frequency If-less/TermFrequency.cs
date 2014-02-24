using System;
using System.Collections.Generic;
using System.IO;
using System.Text.RegularExpressions;
using Term_Frequency_If_less.Data;

namespace Term_Frequency_If_less
{
	public class TermFrequency
	{
		public TermFrequency()
		{

		}

		public void ProcessInput(string input)
        {
            ProcessWords(new List<string>(Regex.Replace(Regex.Replace(input.ToLowerInvariant(), @"[^a-z\s]", ""), @"\s+[a-z]\s+", "")
                .Split(new[] { ' ', '\r', '\n' }, StringSplitOptions.RemoveEmptyEntries)));
        }

        private void ProcessWords(List<string> words)
        {
            RemoveStopWords(words, new HashSet<string>(File.OpenText("../../../Input/stop_words.txt").ReadToEnd().Split(',')));
            CreateCounters(new List<Counter>(), words, new HashSet<string>(words));
        }

        private void RemoveStopWords(List<string> words, HashSet<string> stopWords)
        {
            words.RemoveAll(w => stopWords.Contains(w));
        }

        private void CreateCounters(List<Counter> counters, List<string> words, HashSet<string> uniqueWords)
        {
            new List<string>(uniqueWords).ForEach(w => counters.Add(new Counter()));

            counters.Add(new NullCounter());
            counters[0].Count(counters, words, words.GetEnumerator(), new Dictionary<string, int>());
        }
	}
}
