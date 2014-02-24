using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Term_Frequency
{
	class Program
	{
		static void Main(string[] args)
		{
			string[] inputs =
			{
				File.OpenText("../../../Input/input.txt").ReadToEnd(),
				File.OpenText("../../../Input/pride-and-prejudice.txt").ReadToEnd(),
				File.OpenText("../../../Input/test.txt").ReadToEnd()
			};

			TermFrequency m = new TermFrequency();

			foreach (string input in inputs)
			{
				IEnumerable<KeyValuePair<string, int>> entries = m.CountWordOccurences(input, 25);
				foreach (string entry in entries.Select(kv => kv.Key + " => " + kv.Value))
				{
					Console.WriteLine(entry);
				}
                Console.WriteLine();
			}

			Console.ReadKey();
		}
	}
}
