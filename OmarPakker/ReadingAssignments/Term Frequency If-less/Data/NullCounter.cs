using System.Collections.Generic;

namespace Term_Frequency_If_less.Data
{
    public class NullCounter : Counter
    {
        public override void Count(Stack<Counter> counters, List<string> words, Dictionary<string, int> results)
        {

        }
    }
}
