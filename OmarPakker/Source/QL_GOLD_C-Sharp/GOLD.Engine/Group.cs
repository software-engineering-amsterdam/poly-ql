using System.Collections.Generic;
using GOLD.Engine.Enums;

namespace GOLD.Engine
{
    internal class Group
    {
        internal ushort TableIndex { get; private set; }
        internal string Name { get; private set; }
        internal Symbol Container { get; private set; }
        internal Symbol Start { get; private set; }
        internal Symbol End { get; private set; }

        internal GroupAdvanceMode Advance { get; private set; }
        internal GroupEndingMode Ending { get; private set; }

        //GroupList
        internal IList<ushort> Nesting { get; private set; }

        internal Group(ushort tableIndex, string name, Symbol container, Symbol start, Symbol end,
            GroupAdvanceMode advance, GroupEndingMode ending)
        {
            TableIndex = tableIndex;
            Name = name;
            Container = container;
            Start = start;
            End = end;
            Advance = advance;
            Ending = ending;
            Nesting = new List<ushort>();
        }
    }
}
