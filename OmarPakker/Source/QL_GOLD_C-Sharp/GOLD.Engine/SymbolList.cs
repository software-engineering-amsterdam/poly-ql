using System;
using System.Collections.Generic;
using System.Linq;
using GOLD.Engine.Enums;

namespace GOLD.Engine
{
    public class SymbolList
    {
        public int Count { get { return symbolList.Count; } }

        private IList<Symbol> symbolList;

        internal SymbolList()
        {
            symbolList = new List<Symbol>();
        }

        internal SymbolList(int size)
        {
            symbolList = Enumerable.Repeat<Symbol>(null, size).ToList();
        }

        internal void Add(Symbol symbol)
        {
            symbolList.Add(symbol);
        }

        internal void Clear()
        {
            symbolList.Clear();
        }

        internal Symbol GetFirstOfType(SymbolType type)
        {
            return symbolList.FirstOrDefault(s => s.Type == type);
        }

        public Symbol this[int index]
        {
            get
            {
                return symbolList[index];
            }

            internal set
            {
                symbolList[index] = value;
            }
        }

        public string Text()
        {
            return Text(",", false);
        }

        public string Text(string separator, bool delimitTerminals)
        {
            return String.Join(separator, symbolList.Select(s => s.Text(delimitTerminals)));
        }

        public override string ToString()
        {
            return Text();
        }
    }
}
