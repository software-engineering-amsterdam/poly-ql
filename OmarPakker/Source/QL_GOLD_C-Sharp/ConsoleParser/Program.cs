using System;

namespace QL_GOLD_C_Sharp
{
	public class Program
	{
		static int Main(string[] args)
		{
            ConsoleTypeCheckParser cp = new ConsoleTypeCheckParser();
			bool parsed = cp.Parse(System.IO.File.OpenText(@"..\..\..\..\..\Grammar\QL_Test.txt"));

			Console.ReadKey();

			return parsed ? 0 : -1;
		}
	}
}
