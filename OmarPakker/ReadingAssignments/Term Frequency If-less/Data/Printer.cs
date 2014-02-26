using System;
using System.Collections.Generic;

namespace Term_Frequency_If_less.Data
{
    public class Printer
    {
        public virtual void Print(Stack<Printer> printers, List<KeyValuePair<string, int>>.Enumerator occurenceStepper)
        {
            occurenceStepper.MoveNext();
            Console.WriteLine(occurenceStepper.Current.Key + " => " + occurenceStepper.Current.Value);

            printers.Pop().Print(printers, occurenceStepper);
        }
    }
}
