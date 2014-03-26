using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace Algebra.QL.Form.Environment
{
    public class VarAccessEventArgs : EventArgs
    {
        public IReadOnlyList<int> Instances { get { return new ReadOnlyCollection<int>(instances); } }
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
