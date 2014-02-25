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
            ProcessWords(new List<string>(Regex.Replace(Regex.Replace(input.ToLowerInvariant(), @"[^a-z\s]", " "), @"\s+[a-z]\s+", " ")
                .Split(new[] { ' ', '\r', '\n' }, StringSplitOptions.RemoveEmptyEntries)));
        }

        private void ProcessWords(List<string> words)
        {
            RemoveStopWords(words, new HashSet<string>(File.OpenText("../../../Input/stop_words.txt").ReadToEnd().Split(',')));
            SetupResultsDictionary(new Dictionary<string, int>(), words);
        }

        private void RemoveStopWords(List<string> words, HashSet<string> stopWords)
        {
            words.RemoveAll(w => stopWords.Contains(w));
        }

        private void SetupResultsDictionary(Dictionary<string, int> results, List<string> words)
        {
            CreateAndRunCounters(new List<Counter>(), words, new HashSet<string>(words), results);
            CreateAndRunPrinters(new List<KeyValuePair<string, int>>(results));
        }

        private void CreateAndRunCounters(List<Counter> counters, List<string> words, HashSet<string> uniqueWords, Dictionary<string, int> results)
        {
            new List<string>(uniqueWords).ForEach(w => counters.Add(new Counter()));

            counters.Add(new NullCounter());
            counters[0].Count(counters, words, words.GetEnumerator(), results);
        }

        private void CreateAndRunPrinters(List<KeyValuePair<string, int>> resultsList)
        {
            resultsList.Sort((kv1, kv2) => kv2.Value - kv1.Value);

            CapOutput(new List<Printer>(), new Printer[Math.Min(resultsList.Count, 25)], resultsList);
        }

        private void CapOutput(List<Printer> printers, Printer[] limitedOutput, List<KeyValuePair<string, int>> resultsList)
        {
            resultsList.ForEach(w => printers.Add(new Printer()));
            printers.CopyTo(0, limitedOutput, 0, Math.Min(printers.Count, 25));

            RunPrinters(new List<Printer>(limitedOutput), resultsList);
        }

        private void RunPrinters(List<Printer> printers, List<KeyValuePair<string, int>> resultsList)
        {
            printers.Add(new NullPrinter());
            printers[0].Print(printers, resultsList.GetEnumerator());
        }
    }
}
