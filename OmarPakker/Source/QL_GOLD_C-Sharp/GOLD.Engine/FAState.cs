using System.Collections.Generic;

namespace GOLD.Engine
{
    internal class FAState
    {
        internal ushort TableIndex { get; private set; }
        internal IList<FAEdge> Edges { get; private set; }
        internal Symbol Accept { get; private set; }

        public FAState(ushort tableIndex)
            : this(tableIndex, null)
        {

        }

        public FAState(ushort tableIndex, Symbol symbol)
        {
            TableIndex = tableIndex;
            Edges = new List<FAEdge>();
            Accept = symbol;
        }
    }
}
