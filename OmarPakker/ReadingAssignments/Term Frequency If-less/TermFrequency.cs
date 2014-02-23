using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Term_Frequency_If_less
{
	public class TermFrequency
	{
		private static readonly HashSet<string> StopWords
			= new HashSet<string>(File.OpenText("../../../Input/stop_words.txt").ReadToEnd().Split(','));

		public TermFrequency()
		{

		}

		public void Process(StreamReader reader)
		{
			ExtractWords(reader.ReadToEnd());
		}

		private void ExtractWords(string input)
		{
			RemoveStopWords(new List<string>(input.Split(new[] { ' ', '\r', '\n' }, StringSplitOptions.RemoveEmptyEntries)));
		}

		private void RemoveStopWords(List<string> words)
		{
			
		}

		private void CountWords(string word, int count)
		{

		}
	}
}
