using System;
using System.Collections.Generic;

namespace Term_Frequency_If_less.Data
{
    public class Printer
    {
        public virtual void Print(List<Printer> printers, List<KeyValuePair<string, int>>.Enumerator occurenceStepper)
        {
            occurenceStepper.MoveNext();
            Console.WriteLine(occurenceStepper.Current.Key + " => " + occurenceStepper.Current.Value);

            printers.RemoveAt(0);
            printers[0].Print(printers, occurenceStepper);
        }
    }
}
