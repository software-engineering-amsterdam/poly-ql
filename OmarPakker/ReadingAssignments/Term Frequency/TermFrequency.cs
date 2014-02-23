using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace Term_Frequency
{
	public class TermFrequency
	{
		private static readonly HashSet<string> StopWords
			= new HashSet<string>(File.OpenText("./Input/stop_words.txt").ReadToEnd().Split(','));

		public TermFrequency()
		{

		}

		private IEnumerable<string> ToFilteredWords(string input)
		{
			return new String(input.Where(c => Char.IsLetter(c) || Char.IsWhiteSpace(c)).ToArray())
				.ToLowerInvariant().Split(new[] { ' ', '\r', '\n' }, StringSplitOptions.RemoveEmptyEntries)
				.Where(w => !StopWords.Contains(w));
		}

		public IEnumerable<KeyValuePair<string, int>> CountWordOccurences(StreamReader reader, int maxEntries)
		{
			return CountWordOccurences(reader).Take(maxEntries);
		}

		public IEnumerable<KeyValuePair<string, int>> CountWordOccurences(StreamReader reader)
		{
			Dictionary<string, int> entries = new Dictionary<string, int>();

			while (!reader.EndOfStream)
			{
				foreach (string word in ToFilteredWords(reader.ReadLine()))
				{
					if (!entries.ContainsKey(word))
					{
						entries.Add(word, 0);
					}
					entries[word]++;
				}
			}

			return entries.OrderByDescending(kv => kv.Value);
		}

		public IEnumerable<KeyValuePair<string, HashSet<int>>> GetPagesForWords(StreamReader reader, int maxEntries)
		{
			return GetPagesForWords(reader).Take(maxEntries);
		}

		public IEnumerable<KeyValuePair<string, HashSet<int>>> GetPagesForWords(StreamReader reader)
		{
			Dictionary<string, HashSet<int>> entries = new Dictionary<string, HashSet<int>>();
			int lineCounter = 1;
			int pageCounter = 1;

			while (!reader.EndOfStream)
			{
				lineCounter++;
				pageCounter = lineCounter / 45;

				foreach (string word in ToFilteredWords(reader.ReadLine()))
				{
					if (!entries.ContainsKey(word))
					{
						entries.Add(word, new HashSet<int>());
					}
					entries[word].Add(pageCounter);
				}
			}

			return entries.OrderBy(kv => kv.Key);
		}
	}
}
