using System;
using System.IO;

namespace Term_Frequency_If_less
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
                m.ProcessInput(input);
                Console.ReadKey();
			}
		}
	}
}
