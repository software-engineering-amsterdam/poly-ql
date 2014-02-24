using System.Collections.Generic;

namespace Term_Frequency_If_less.Data
{
    public class Counter
    {
        public virtual void Count(List<Counter> counters, List<string> words, List<string>.Enumerator wordStepper, Dictionary<string, int> results)
        {
            wordStepper.MoveNext();
            results.Add(wordStepper.Current, words.RemoveAll(w => w.Equals(wordStepper.Current)));

            counters.RemoveAt(0);
            counters[0].Count(counters, words, words.GetEnumerator(), results);
        }
    }
}
