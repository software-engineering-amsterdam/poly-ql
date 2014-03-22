using System;

namespace Algebra.QL.TypeCheck.Helpers
{
    public class VarAccessEventArgs : EventArgs
    {
        public string VarName { get; private set; }

        public VarAccessEventArgs(string varName)
        {
            VarName = varName;
        }

        public void MarkRepeated()
        {
            VarName += "$";
        }
    }
}
