using System.Collections.Generic;

namespace Term_Frequency_If_less.Data
{
    public class NullCounter : Counter
    {
        public override void Count(List<Counter> counters, List<string> words, List<string>.Enumerator wordStepper, Dictionary<string, int> results)
        {

        }
    }
}
