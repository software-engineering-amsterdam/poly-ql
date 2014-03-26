using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;

namespace Algebra.QL.Form.Helpers
{
    public class VarEnvironment<T> : Algebra.Core.Helpers.VarEnvironment<T>
    {
        private const char RepeatedSuffix = '$';

        public event Action<VarAccessEventArgs> VarAccess;

        private readonly IDictionary<string, ObservableCollection<T>> repeatedVariables;

        public VarEnvironment()
            : base()
        {
            repeatedVariables = new Dictionary<string, ObservableCollection<T>>();
        }

        protected void OnVarAccess(VarAccessEventArgs args)
        {
            if (VarAccess != null)
            {
                VarAccess(args);
            }
        }

        public string VarNameToInstancedName(string name, VarAccessEventArgs eventArgs)
        {
            for (int i = 0; i < eventArgs.Instances.Count - 1; i++)
            {
                name += RepeatedSuffix + i;
            }

            return name;
        }

        public override void Declare(string name, T value)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            if (eventArgs.IsInstanced)
            {
                string instancedName = VarNameToInstancedName(name, eventArgs);

                if (!repeatedVariables.ContainsKey(instancedName))
                {
                    repeatedVariables.Add(instancedName, new ObservableCollection<T>());
                }

                repeatedVariables[instancedName].Add(value);
                return;
            }

            base.Declare(name, value);
        }

        public override bool IsDeclared(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            if (eventArgs.IsInstanced)
            {
                string instanceName = VarNameToInstancedName(name, eventArgs);
                return repeatedVariables.ContainsKey(instanceName)
                    && repeatedVariables[instanceName].Count > eventArgs.Instances.Last();
            }

            return base.IsDeclared(name);
        }

        public override T GetDeclared(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            Debug.Assert(!eventArgs.IsInstanced || eventArgs.Instances.Count == 1,
                "Instanced variables can't be grabbed as a single entry!");

            if (eventArgs.IsInstanced)
            {
                return repeatedVariables[name][eventArgs.Instances[0]];
            }

            return base.GetDeclared(name);
        }

        public override void Clear()
        {
            Debug.Assert(VarAccess == null, "Some events weren't unregistered!");

            base.Clear();
        }

        public virtual bool IsRepeated(string name)
        {
            return repeatedVariables.ContainsKey(name);
        }

        public virtual ObservableCollection<T> GetRange(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            Debug.Assert(eventArgs.IsInstanced || repeatedVariables[name].Count > 0, "Non-instanced variables can't be grabbed as a range!");

            return repeatedVariables[name];
        }
    }
}
