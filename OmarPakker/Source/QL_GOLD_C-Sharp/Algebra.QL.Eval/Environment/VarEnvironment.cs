using System;
using System.Diagnostics;
using Algebra.Core.Collections;

namespace Algebra.QL.Eval.Environment
{
    public class VarEnvironment<T> : Algebra.Core.Environment.VarEnvironment<T>
    {
        private const char RepeatedSuffix = '$';

        public event Action<VarAccessEventArgs> VarAccess;

        public VarEnvironment()
            : base()
        {

        }

        protected void OnVarAccess(VarAccessEventArgs args)
        {
            if (VarAccess != null)
            {
                VarAccess(args);
            }
        }

        protected string VarNameToInstancedName(string name, VarAccessEventArgs args)
        {
            for (int i = 0; i < args.Instances.Count; i++)
            {
                name += RepeatedSuffix + args.Instances[i].ToString();
            }

            return name;
        }

        public override void Declare(string name, T value)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            base.Declare(VarNameToInstancedName(name, eventArgs), value);
        }

        public override bool IsDeclared(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            if (eventArgs.IsInstanced)
            {
                string instancedName = VarNameToInstancedName(name, eventArgs);

                for (string stepName = instancedName; stepName.IndexOf(RepeatedSuffix) >= 0; stepName = stepName.Substring(0, stepName.LastIndexOf(RepeatedSuffix)))
                {
                    if (base.IsDeclared(stepName))
                    {
                        return true;
                    }
                }
            }

            return base.IsDeclared(name);
        }

        public override T GetDeclared(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            if (eventArgs.IsInstanced)
            {
                string instancedName = VarNameToInstancedName(name, eventArgs);

                for (string stepName = instancedName; stepName.IndexOf(RepeatedSuffix) >= 0; stepName = stepName.Substring(0, stepName.LastIndexOf(RepeatedSuffix)))
                {
                    if (base.IsDeclared(stepName))
                    {
                        return base.GetDeclared(stepName);
                    }
                }
            }

            return base.GetDeclared(name);
        }

        public override void Clear()
        {
            Debug.Assert(VarAccess == null, "Some events weren't unregistered!");

            base.Clear();
        }

        public virtual DictionaryKeyValueObserver<string, T> GetRange(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            string instancedName = VarNameToInstancedName(name, eventArgs) + RepeatedSuffix;

            return new DictionaryKeyValueObserver<string,T>(Variables, (kv) => kv.Key.StartsWith(instancedName));
        }
    }
}
