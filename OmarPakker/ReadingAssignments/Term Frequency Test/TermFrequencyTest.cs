using System.Collections.Generic;
using System.IO;
using System.Linq;
using TermFrequency;
using Xunit;

namespace Term_Frequency_Test
{
	public class TermFrequencyTest
	{
		private readonly TermFrequency main;
		private readonly StreamReader[] readers;
		private readonly HashSet<string> stopWords;

		public TermFrequencyTest()
		{
			main = new TermFrequency();
			readers = new[]
			{
				File.OpenText("./Input/input.txt"),
				File.OpenText("./Input/pride-and-prejudice.txt"),
				File.OpenText("./Input/test.txt")
			};
			stopWords = new HashSet<string>(File.OpenText("./Input/stop_words.txt").ReadToEnd().Split(','));
		}

		[Fact]
		public void NoStopWords()
		{
			foreach (StreamReader reader in readers)
			{
				foreach (string word in main.CountWordOccurences(reader).Select(kv => kv.Key))
				{
					Assert.DoesNotContain(word, stopWords);
				}
			}
		}

		[Fact]
		public void CorrectNumberOfEntries()
		{
			Assert.Equal(main.CountWordOccurences(readers[0], 25).Count(), 8);
			Assert.Equal(main.CountWordOccurences(readers[1], 25).Count(), 25);
			Assert.Equal(main.CountWordOccurences(readers[2], 25).Count(), 4);
		}

		[Fact]
		public void CaseInsensitive()
		{
			foreach(StreamReader reader in readers)
			{
				IEnumerable<string> words = main.CountWordOccurences(reader).Select(kv => kv.Key);
				Assert.Equal(new HashSet<string>(words.Select(w => w.ToLowerInvariant())), words);
			}
		}

		[Fact]
		public void DecreasingOrder()
		{
			foreach (StreamReader reader in readers)
			{
				KeyValuePair<string, int>[] entries = main.CountWordOccurences(reader).ToArray();

				for (int i = entries.Length - 1; i > 0; i--)
				{
					for (int j = i - 1; j >= 0; j--)
					{
						Assert.True(entries[i].Value <= entries[j].Value);
					}
				}
			}
		}
	}
}
