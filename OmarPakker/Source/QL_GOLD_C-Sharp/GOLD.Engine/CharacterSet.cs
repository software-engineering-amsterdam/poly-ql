using System.Collections.Generic;
using System.Linq;

namespace GOLD.Engine
{
    internal class CharacterSet
    {
        internal int Count { get { return characterList.Count; } }
        internal ushort Index { get; private set; }

        private IList<CharacterRange> characterList;

        internal CharacterSet(ushort index, int size)
        {
            Index = index;
            characterList = new List<CharacterRange>(size);
        }

        internal void Add(CharacterRange charRange)
        {
            characterList.Add(charRange);
        }

        internal bool Contains(ushort charCode)
        {
            return characterList.Any(range => range.Start <= charCode && charCode <= range.End);
        }
    }
}
