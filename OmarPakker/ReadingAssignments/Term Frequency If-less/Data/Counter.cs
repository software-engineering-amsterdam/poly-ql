using System.Collections.Generic;

namespace Term_Frequency_If_less.Data
{
    public class Counter
    {
        public virtual void Count(Stack<Counter> counters, List<string> words, Dictionary<string, int> results)
        {
            results.Add(words[words.Count - 1], words.RemoveAll(w => w.Equals(words[words.Count - 1])));

            counters.Pop().Count(counters, words, results);
        }
    }
}
