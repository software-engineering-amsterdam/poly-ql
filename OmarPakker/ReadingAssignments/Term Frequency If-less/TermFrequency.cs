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
            CreateCounters(new Dictionary<string, Counter>(), words);
        }

        private void RemoveStopWords(List<string> words, HashSet<string> stopWords)
        {
            words.RemoveAll(w => stopWords.Contains(w));
        }

        private void CreateCounters(Dictionary<string, Counter> counters, List<string> words)
        {
            words.ForEach(w => counters[w] = new Counter());

            StartCounterRecursion(new List<Counter>(counters.Values), words);
        }

        private void StartCounterRecursion(List<Counter> counters, List<string> words)
        {
            counters.Add(new NullCounter());

            counters[0].Count(counters, words, words.GetEnumerator(), new Dictionary<string, int>());
        }
	}
}
