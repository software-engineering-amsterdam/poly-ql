using System;

namespace Algebra.QL.TypeCheck.Environment
{
    public class VarAccessEventArgs : EventArgs
    {
        public int RepeatCount { get; private set; }
        public bool IsInstanced { get { return RepeatCount > 0; } }

        public VarAccessEventArgs()
        {

        }

        public void MarkRepeated()
        {
            RepeatCount++;
        }
    }
}
