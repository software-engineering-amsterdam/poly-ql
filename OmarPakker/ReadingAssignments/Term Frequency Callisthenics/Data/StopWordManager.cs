using System.Collections.Generic;
using System.IO;

namespace Term_Frequency_Callisthenics.Data
{
    public static class StopWordManager
    {
        private static readonly HashSet<Word> StopWords;

        static StopWordManager()
        {
            StopWords = new HashSet<Word>();

            StreamReader stopWordsFileStream = File.OpenText("../../../Input/stop_words.txt");
            string stopWordsFileContents = stopWordsFileStream.ReadToEnd();
            foreach (string word in stopWordsFileContents.Split(','))
            {
                StopWords.Add(new Word(word));
            }
        }

        public static bool IsStopWord(Word word)
        {
            return StopWords.Contains(word);
        }
    }
}
