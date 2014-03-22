using System.Collections.Generic;

namespace Algebra.Core.Helpers
{
    public class VarEnvironment<T>
    {
        protected IDictionary<string, T> Variables { get; private set; }

        public VarEnvironment()
        {
            Variables = new Dictionary<string, T>();
        }

        public virtual void Declare(string name, T value)
        {
            Variables[name] = value;
        }

        public virtual bool IsDeclared(string name)
        {
            return Variables.ContainsKey(name);
        }

        public virtual T GetDeclared(string name)
        {
            return Variables[name];
        }

        public virtual void Clear()
        {
            Variables.Clear();
        }
    }
}
