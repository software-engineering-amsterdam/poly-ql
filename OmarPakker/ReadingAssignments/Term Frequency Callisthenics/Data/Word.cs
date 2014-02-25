
namespace Term_Frequency_Callisthenics.Data
{
    public class Word
    {
        private readonly string _word;

        public Word(string word)
        {
            _word = word;
        }

        public bool IsLongerThanOne()
        {
            return _word.Length > 1;
        }

        public override bool Equals(object obj)
        {
            if(!(obj is Word))
            {
                return false;
            }

            string otherWord = ((Word)obj)._word;
            return _word.Equals(otherWord);
        }

        public override int GetHashCode()
        {
            return _word.GetHashCode();
        }

        public override string ToString()
        {
            return _word;
        }
    }
}
