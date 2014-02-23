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
			StreamReader[] readers =
			{
				File.OpenText("./Input/input.txt"),
				File.OpenText("./Input/pride-and-prejudice.txt"),
				File.OpenText("./Input/test.txt")
			};

			TermFrequency m = new TermFrequency();

			foreach (StreamReader reader in readers)
			{
				IEnumerable<KeyValuePair<string, int>> entries = m.CountWordOccurences(reader, 25);
				foreach (string entry in entries.Select(kv => kv.Key + " => " + kv.Value))
				{
					Console.WriteLine(entry);
				}

				Console.WriteLine();
				reader.BaseStream.Position = 0;

				IEnumerable<KeyValuePair<string, HashSet<int>>> pages = m.GetPagesForWords(reader, 25);
				foreach (string entry in pages.Select(kv => kv.Key + " => " + String.Join(", ", kv.Value)))
				{
					Console.WriteLine(entry);
				}

				Console.ReadKey();
				Console.WriteLine();
			}

			Console.ReadKey();
		}
	}
}
