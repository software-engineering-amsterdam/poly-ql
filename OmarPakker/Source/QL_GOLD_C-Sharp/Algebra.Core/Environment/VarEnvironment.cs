using System.Collections.Generic;
using Algebra.Core.Collections;

namespace Algebra.Core.Environment
{
    public class VarEnvironment<T>
    {
        protected ObservableDictionary<string, T> Variables { get; private set; }

        public VarEnvironment()
        {
            Variables = new ObservableDictionary<string, T>();
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
