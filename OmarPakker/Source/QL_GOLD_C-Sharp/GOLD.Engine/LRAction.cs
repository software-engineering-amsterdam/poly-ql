using GOLD.Engine.Enums;

namespace GOLD.Engine
{
    internal class LRAction
    {
        internal Symbol Symbol { get; set; }
        internal LRActionType Type { get; set; }
        internal ushort Value { get; set; }

        internal LRAction(Symbol symbol, LRActionType type, ushort value)
        {
            Symbol = symbol;
            Type = type;
            Value = value;
        }
    }
}
