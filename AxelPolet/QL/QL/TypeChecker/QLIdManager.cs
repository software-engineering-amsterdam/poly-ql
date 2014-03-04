using System;
using System.Collections.Generic;
using QL.QLClasses.Expressions.Identifier;
using QL.QLClasses.Types;

namespace QL.TypeChecker
{
    public class QLIdManager
    {
        private Dictionary<string, QIdentifier> _ids;
        private Dictionary<string, List<string>> _dependencies;

        public QLIdManager()
        {
            _ids = new Dictionary<string, QIdentifier>();
            _dependencies = new Dictionary<string, List<string>>();
        }

        public void AddId(string name, QIdentifier identifier)
        {
            _ids[name] = identifier;
        }

        public bool Exists(string name)
        {
            return _ids.ContainsKey(name);
        }

        public QIdentifier GetIdentifierByString(string name)
        {
            return _ids[name];
        }
    }
}
