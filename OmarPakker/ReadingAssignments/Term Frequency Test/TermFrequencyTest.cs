using System.Collections.Generic;
using System.IO;
using System.Linq;
using Term_Frequency;
using Xunit;

namespace Term_Frequency_Test
{
    public class TermFrequencyTest
    {
        private readonly TermFrequency tf;
        private readonly string[] testInputs;
        private readonly HashSet<string> stopWords;

        public TermFrequencyTest()
        {
            tf = new TermFrequency();
            testInputs = new[]
			{
				File.OpenText("../../../Input/input.txt").ReadToEnd(),
				File.OpenText("../../../Input/pride-and-prejudice.txt").ReadToEnd(),
				File.OpenText("../../../Input/test.txt").ReadToEnd(),
                "Casing casing CASING",
                "a able about among problem"
			};
            stopWords = new HashSet<string>(File.OpenText("../../../Input/stop_words.txt").ReadToEnd().Split(','));
        }

        [Fact]
        public void NoStopWords()
        {
            foreach (string input in testInputs)
            {
                foreach (string word in tf.RemoveStopWordsFromList(tf.ToFilteredWords(input)))
                {
                    Assert.DoesNotContain(word, stopWords);
                }
            }
        }

        [Fact]
        public void CorrectNumberOfEntries()
        {
            int[] expectedResults = new[] { 8, 25, 4, 1, 1 };

            for (int i = 0; i < testInputs.Length; i++)
            {
                Assert.Equal(tf.CountWordOccurences(testInputs[i], 25).Count(), expectedResults[i]);
            }
        }

        [Fact]
        public void CaseInsensitive()
        {
            foreach (string input in testInputs)
            {
                IEnumerable<string> words = tf.ToFilteredWords(input);
                Assert.Equal(new List<string>(words.Select(w => w.ToLowerInvariant())), words);
            }
        }

        [Fact]
        public void DecreasingOrder()
        {
            foreach (string input in testInputs)
            {
                KeyValuePair<string, int>[] entries = tf.CountWordOccurences(input).ToArray();

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
