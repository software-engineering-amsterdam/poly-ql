using System;
using System.Collections.Generic;

namespace Algebra.QL.Core.Environment
{
    //TODO: Move to extensions once environment is independent
    public class VarAccessEventArgs : EventArgs
    {
        public IList<int> Instances { get { return new List<int>(instances); } }
        public bool IsInstanced { get { return instances.Count > 0; } }

        private IList<int> instances;

        public VarAccessEventArgs()
        {
            instances = new List<int>();
        }

        public void SetVarBaseInstances(IEnumerable<int> baseInstances)
        {
            foreach (int instance in baseInstances)
            {
                instances.Add(instance);
            }
        }

        public void SetVarInstance(int instance)
        {
            instances.Add(instance);
        }
    }
}
