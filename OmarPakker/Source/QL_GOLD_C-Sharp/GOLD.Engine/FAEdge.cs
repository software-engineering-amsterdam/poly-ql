using System.Collections.Generic;

namespace GOLD.Engine
{
    internal class FAEdge
    {
        internal CharacterSet Characters { get; private set; }
        internal int Target { get; private set; }

        internal FAEdge(CharacterSet characters, int target)
        {
            Characters = characters;
            Target = target;
        }
    }
}
