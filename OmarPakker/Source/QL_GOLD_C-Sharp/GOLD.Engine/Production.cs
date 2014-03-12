using GOLD.Engine.Enums;

namespace GOLD.Engine
{
    public class Production
    {
        public Symbol Head { get; private set; }
        public SymbolList Handle { get; private set; }
        public ushort TableIndex { get; private set; }

        internal Production()
        {

        }

        internal Production(Symbol head, ushort tableIndex)
        {
            Head = head;
            Handle = new SymbolList();
            TableIndex = tableIndex;
        }

        internal bool ConsistsOfOneNonTerminal()
        {
            if (Handle.Count == 1 && Handle[0].Type == SymbolType.Nonterminal)
            {
                return true;
            }

            return false;
        }

        public string Text()
        {
            return Text(false);
        }

        public string Text(bool delimitTerminals)
        {
            return Head.Text() + " ::= " + Handle.Text(",", delimitTerminals);
        }

        public override string ToString()
        {
            return Text();
        }
    }
}
