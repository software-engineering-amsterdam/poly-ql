using System;

namespace ConsoleParser
{
	public class Program
	{
		static void Main(string[] args)
		{
            ConsoleTypeChecker obj = new ConsoleTypeChecker();
            obj.RunDefaultParser();

			Console.ReadKey();

            obj.RunExtensionsParser();

            Console.ReadKey();
		}
	}
}
