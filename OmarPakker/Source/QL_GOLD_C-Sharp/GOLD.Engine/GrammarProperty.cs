
namespace GOLD.Engine
{
    public class GrammarProperty
    {
        public ushort PropertyIndex { get; private set; }
        public string Name { get; private set; }
        public string Value { get; private set; }

        public GrammarProperty(ushort propertyIndex, string name, string value)
        {
            PropertyIndex = propertyIndex;
            Name = name;
            Value = value;
        }
    }
}
