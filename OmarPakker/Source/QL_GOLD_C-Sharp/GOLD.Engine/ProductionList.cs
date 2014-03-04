using System;
using System.Collections.Generic;
using System.Linq;

namespace GOLD.Engine
{
    public class ProductionList
    {
        public int Count { get { return productionList.Count; } }

        private IList<Production> productionList;

        internal ProductionList(int size)
        {
            productionList = Enumerable.Repeat<Production>(null, size).ToList();
        }

        internal void Add(Production production)
        {
            productionList.Add(production);
        }

        internal void Clear()
        {
            productionList.Clear();
        }

        public Production this[int index]
        {
            get
            {
                return productionList[index];
            }

            internal set
            {
                productionList[index] = value;
            }
        }

        public string Text()
        {
            return Text(",", false);
        }

        public string Text(string separator, bool delimitTerminals)
        {
            return String.Join(separator, productionList.Select(s => s.Text(delimitTerminals)));
        }

        public override string ToString()
        {
            return Text();
        }
    }
}
