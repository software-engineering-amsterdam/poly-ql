using System;
using System.Diagnostics;
using Algebra.Core.Collections;
using Algebra.Core.Environment;

namespace Algebra.QL.Core.Environment
{
    //TODO: Move to extensions once environment is independent
    public class ExtVarEnvironment<T> : IVarEnvironment<T>
    {
        private const char RepeatedSuffix = '$';

        public event Action<VarAccessEventArgs> VarAccess;

        private readonly ObservableDictionary<string, T> variables;

        public ExtVarEnvironment()
        {
            variables = new ObservableDictionary<string, T>();
        }

        private void OnVarAccess(VarAccessEventArgs args)
        {
            if (VarAccess != null)
            {
                VarAccess(args);
            }
        }

        private string VarNameToInstancedName(string name, VarAccessEventArgs args)
        {
            for (int i = 0; i < args.Instances.Count; i++)
            {
                name += RepeatedSuffix + args.Instances[i].ToString();
            }

            return name;
        }

        public void Declare(string name, T value)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            variables[VarNameToInstancedName(name, eventArgs)] = value;
        }

        public bool IsDeclared(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            if (eventArgs.IsInstanced)
            {
                string instancedName = VarNameToInstancedName(name, eventArgs);

                for (string stepName = instancedName; stepName.IndexOf(RepeatedSuffix) >= 0; stepName = stepName.Substring(0, stepName.LastIndexOf(RepeatedSuffix)))
                {
                    if (variables.ContainsKey(stepName))
                    {
                        return true;
                    }
                }
            }

            return variables.ContainsKey(name);
        }

        public T GetDeclared(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            if (eventArgs.IsInstanced)
            {
                string instancedName = VarNameToInstancedName(name, eventArgs);

                for (string stepName = instancedName; stepName.IndexOf(RepeatedSuffix) >= 0; stepName = stepName.Substring(0, stepName.LastIndexOf(RepeatedSuffix)))
                {
                    if (variables.ContainsKey(stepName))
                    {
                        return variables[stepName];
                    }
                }
            }

            return variables[name];
        }

        public void Clear()
        {
            Debug.Assert(VarAccess == null, "Some events weren't unregistered!");

            variables.Clear();
        }

        public DictionaryKeyValueObserver<string, T> GetRange(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            string instancedName = VarNameToInstancedName(name, eventArgs) + RepeatedSuffix;

            return new DictionaryKeyValueObserver<string,T>(variables, (kv) => kv.Key.StartsWith(instancedName));
        }
    }
}
