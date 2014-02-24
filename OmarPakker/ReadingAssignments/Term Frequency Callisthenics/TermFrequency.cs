using System.Collections.Generic;
using System.IO;

namespace Term_Frequency_Callisthenics
{
	public class TermFrequency
	{
		private static readonly HashSet<string> StopWords
			= new HashSet<string>(File.OpenText("../../../Input/stop_words.txt").ReadToEnd().Split(','));

		public TermFrequency()
		{

		}
	}
}
