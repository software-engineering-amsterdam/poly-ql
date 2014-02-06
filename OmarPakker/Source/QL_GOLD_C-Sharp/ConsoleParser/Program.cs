using System;
using System.IO;
using System.Reflection;
using com.OPCreations.GoldParser;

namespace QL_GOLD_C_Sharp
{
	public class Program
	{
		static int Main(string[] args)
		{
			try
			{
				Assembly a = Assembly.GetExecutingAssembly();
				BinaryReader br = new BinaryReader(a.GetManifestResourceStream("QL_GOLD_C_Sharp.Grammar.QL_Grammar.egt"));

				BaseParser tp = new ConsoleParser();
				bool loaded = tp.LoadGrammar(br);
				bool parsed = tp.Parse(System.IO.File.OpenText(@"C:\School\Master\Repos\Software Construction\poly-ql\OmarPakker\Grammar\QL_Test.txt"));
				
				return loaded && parsed ? 0 : -1;
			}
			catch
			{
				Console.WriteLine("Error accessing resources!");
			}
			
			Console.ReadKey();

			return -1;
		}
	}
}
