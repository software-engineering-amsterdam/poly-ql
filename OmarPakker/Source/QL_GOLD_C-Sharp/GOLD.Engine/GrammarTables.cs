using System.Collections.Generic;
using System.Linq;

namespace GOLD.Engine
{
    internal class GrammarTables
    {
        internal IList<Symbol> Symbols { get; private set; }
        internal IList<CharacterSet> CharacterSets { get; private set; }
        internal IList<Production> Productions { get; private set; }
        internal IList<FAState> FAStates { get; private set; }
        internal IList<LRActionList> LRActionLists { get; private set; }
        internal IList<Group> Groups { get; private set; }

        public GrammarTables(ushort symbolsSize, ushort charSetsSize, ushort productionsSize,
            ushort faStatesSize, ushort lrActionsListsSize, ushort groupsSize)
        {
            Symbols = Enumerable.Repeat<Symbol>(null, symbolsSize).ToList();
            CharacterSets = Enumerable.Repeat<CharacterSet>(null, charSetsSize).ToList();
            Productions = Enumerable.Repeat<Production>(null, productionsSize).ToList();
            FAStates = Enumerable.Repeat<FAState>(null, faStatesSize).ToList();
            LRActionLists = Enumerable.Repeat<LRActionList>(null, lrActionsListsSize).ToList();
            Groups = Enumerable.Repeat<Group>(null, groupsSize).ToList();
        }

        internal void Clear()
        {
            Symbols.Clear();
            CharacterSets.Clear();
            Productions.Clear();
            FAStates.Clear();
            LRActionLists.Clear();
            Groups.Clear();
        }
    }
}
