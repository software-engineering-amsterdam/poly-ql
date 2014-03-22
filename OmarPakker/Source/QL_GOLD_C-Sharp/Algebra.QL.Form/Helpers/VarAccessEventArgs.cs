using System;

namespace Algebra.QL.Form.Helpers
{
    public class VarAccessEventArgs : EventArgs
    {
        public string VarName { get; private set; }

        public VarAccessEventArgs(string varName)
        {
            VarName = varName;
        }

        public void SetVarSuffix(string suffix)
        {
            VarName += suffix;
        }
    }
}
