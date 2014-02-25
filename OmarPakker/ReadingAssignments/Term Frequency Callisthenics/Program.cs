using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using Term_Frequency_Callisthenics.Data;

namespace Term_Frequency_Callisthenics
{
    class Program
    {
        static void Main(string[] args)
        {
            StreamReader inputFileStream = File.OpenText("../../../Input/pride-and-prejudice.txt");
            string fileContent = inputFileStream.ReadToEnd();

            FileContentProcessor processor = new FileContentProcessor(fileContent);
            IEnumerable<KeyValuePair<Word, OccurenceCount>> occurences = processor.ProcessWords();

            foreach (KeyValuePair<Word, OccurenceCount> occurence in occurences.Take(25))
            {
                Word word = occurence.Key;
                OccurenceCount count = occurence.Value;
                Console.WriteLine(word + " => " + count);
            }

            Console.ReadKey();
        }
    }
}
