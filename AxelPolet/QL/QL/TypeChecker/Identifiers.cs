using System.Collections.Generic;
using QL.QLClasses.Expressions.Identifier;

namespace QL.TypeChecker
{
    public class Identifiers
    {
        private readonly static Dictionary<string, QIdentifier> _identifiers = new Dictionary<string, QIdentifier>();

        public static bool IsDefined(string id)
        {
            return _identifiers.ContainsKey(id);
        }

        public static void AddIdentifier(string id, QIdentifier identifier)
        {
            _identifiers.Add(id, identifier);
        }

        public static QIdentifier GetIdentifier(string id)
        {
            return _identifiers[id];
        }

        public static void Reset()
        {
            _identifiers.Clear();
        }
    }
}
