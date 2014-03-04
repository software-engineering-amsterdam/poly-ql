using System;
using GOLD.Engine.Enums;

namespace GOLD.Engine
{
    public class Symbol
    {
        public string Name { get; private set; }
        public SymbolType Type { get; private set; }
        public ushort TableIndex { get; private set; }
        internal Group Group { get; set; }

        internal Symbol(string name, SymbolType type, ushort tableIndex)
        {
            Name = name;
            Type = type;
            TableIndex = tableIndex;
        }

        private string LiteralFormat(string source, bool forceDelimit)
        {
            if (source == "'")
            {
                return "''";
            }

            for (int i = 0; i < source.Length && !forceDelimit; i++)
            {
                char ch = source[i];
                forceDelimit = !(Char.IsLetter(ch) || ch == '.' || ch == '_' || ch == '-');
            }

            return forceDelimit ? "'" + source + "'" : source;
        }

        public string Text()
        {
            return Text(false);
        }

        public string Text(bool delimitTerminals)
        {
            switch (Type)
            {
                case SymbolType.Nonterminal:
                    return "<" + Name + ">";

                case SymbolType.Content:
                    return LiteralFormat(Name, delimitTerminals);

                default:
                    return "(" + Name + ")";
            }
        }

        public override string ToString()
        {
            return Text();
        }
    }
}
