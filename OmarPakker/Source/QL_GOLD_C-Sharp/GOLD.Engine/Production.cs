using System;
using System.Collections.Generic;
using GOLD.Engine.Enums;

namespace GOLD.Engine
{
    public class Production
    {
        public Symbol Head { get; private set; }
        public IList<Symbol> Handle { get; private set; }
        public ushort TableIndex { get; private set; }

        internal Production()
        {

        }

        internal Production(Symbol head, ushort tableIndex)
        {
            Head = head;
            Handle = new List<Symbol>();
            TableIndex = tableIndex;
        }

        internal bool ConsistsOfOneNonTerminal()
        {
            return Handle.Count == 1 && Handle[0].Type == SymbolType.Nonterminal;
        }

        public override string ToString()
        {
            return Head + " ::= " + String.Join(",", Handle);
        }
    }
}
