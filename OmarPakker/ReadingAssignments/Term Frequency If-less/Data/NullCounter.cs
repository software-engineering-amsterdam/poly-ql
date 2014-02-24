using System;
using System.Collections.Generic;

namespace Term_Frequency_If_less.Data
{
    public class NullCounter : Counter
    {
        public override void Count(List<Counter> counters, List<string> words, List<string>.Enumerator wordStepper, Dictionary<string, int> result)
        {
            ProcessResults(new List<KeyValuePair<string, int>>(result));
        }

        private void ProcessResults(List<KeyValuePair<string, int>> resultsList)
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
