using System.Collections.Generic;

namespace GOLD.Engine
{
    public class GrammarProperties
    {
        private IDictionary<string, GrammarProperty> properties;

        internal GrammarProperties()
        {
            properties = new Dictionary<string, GrammarProperty>();
        }

        internal void SetProperty(GrammarProperty property)
        {
            properties.Add(property.Name, property);
        }

        public GrammarProperty this[string index]
        {
            get
            {
                return properties.ContainsKey(index) ? properties[index] : null;
            }
        }
    }
}
