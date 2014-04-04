using System.Collections.Generic;
using System.Linq;

namespace GOLD.Engine
{
    internal class LRActionList
    {
        internal ushort Index { get; private set; }
        internal int Count { get { return actionList.Count; } }

        private IList<LRAction> actionList;

        internal LRActionList(ushort index)
        {
            Index = index;
            actionList = new List<LRAction>();
        }

        internal void Add(LRAction action)
        {
            actionList.Add(action);
        }

        internal void Clear()
        {
            actionList.Clear();
        }

        internal Symbol this[int index]
        {
            get
            {
                return actionList[index].Symbol;
            }
        }

        internal LRAction this[Symbol symbol]
        {
            get
            {
                return actionList.FirstOrDefault(a => a.Symbol.Equals(symbol));
            }
        }
    }
}
