using System;
using System.IO;

namespace Term_Frequency_If_less
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

			Main m = new Main();

			foreach (StreamReader reader in readers)
			{
				m.Process(reader);
			}

			Console.ReadKey();
		}
	}
}
