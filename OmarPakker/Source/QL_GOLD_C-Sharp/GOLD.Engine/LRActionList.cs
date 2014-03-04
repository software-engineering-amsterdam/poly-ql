using System.Collections.Generic;

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

        //Returns the index of SymbolIndex in the table, -1 if not found
        internal int IndexOf(Symbol symbol)
        {
            for(int i = 0; i < Count; i++)
            {
                if(actionList[i].Symbol.Equals(symbol))
                {
                    return i;
                }
            }

            return -1;
        }

        internal LRAction this[int index]
        {
            get
            {
                return actionList[index];
            }

            set
            {
                actionList[index] = value;
            }
        }

        internal LRAction this[Symbol symbol]
        {
            get
            {
                int index = IndexOf(symbol);
                return index != -1 ? actionList[index] : null;
            }
            set
            {
                int index = IndexOf(symbol);
                if (index != -1)
                {
                    actionList[index] = value;
                }
            }
        }
    }
}
