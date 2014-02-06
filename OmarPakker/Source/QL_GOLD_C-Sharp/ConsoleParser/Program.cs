using System;
using com.OPCreations.GoldParser;

namespace QL_GOLD_C_Sharp
{
	public class Program
	{
		static int Main(string[] args)
		{
			BaseParser tp = new ConsoleParser();
			bool a = tp.LoadGrammar(@".\Grammar\QL_Grammar.egt");
			bool b = tp.Parse(System.IO.File.OpenText(@"C:\School\Master\Repos\Software Construction\poly-ql\OmarPakker\Grammar\QL_Test.txt"));

			Console.ReadKey();

			return a && b ? 0 : -1;
		}
	}
}
