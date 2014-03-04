
namespace GOLD.Engine
{
    internal class CharacterRange
    {
        internal ushort Start { get; private set; }
        internal ushort End { get; private set; }

        internal CharacterRange(ushort start, ushort end)
        {
            Start = start;
            End = end;
        }
    }
}
