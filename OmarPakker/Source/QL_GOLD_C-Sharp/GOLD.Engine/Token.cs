using System;
using GOLD.Engine.Enums;

namespace GOLD.Engine
{
    public class Token
    {
        public ushort State { get; internal set; }
        public virtual Tuple<int, int> StartPosition { get; internal set; }
        public virtual Tuple<int, int> EndPosition { get; internal set; }
        public Symbol Symbol { get; internal set; }
        public string Data { get; internal set; }
        public virtual object Tag { get { return Data; } set { Data = value.ToString(); } }

        public SymbolType Type { get { return Symbol.Type; } }
        internal Group Group { get { return Symbol.Group; } }

        internal Token()
        {
            State = 0;
        }

        internal Token(Symbol parent, string data)
        {
            State = 0;
            Symbol = parent;
            Data = data;
        }
    }
}
