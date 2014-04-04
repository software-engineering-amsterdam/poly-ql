using System.Collections.Generic;
using Algebra.Core.Environment;

namespace Algebra.QL.Core.Environment
{
    public class VarEnvironment<T> : IVarEnvironment<T>
    {
        private readonly IDictionary<string, T> variables;

        public VarEnvironment()
        {
            variables = new Dictionary<string, T>();
        }

        public void Declare(string name, T value)
        {
            variables[name] = value;
        }

        public bool IsDeclared(string name)
        {
            return variables.ContainsKey(name);
        }

        public T GetDeclared(string name)
        {
            return variables[name];
        }

        public void Clear()
        {
            variables.Clear();
        }
    }
}
