using System;
using System.Diagnostics;
using Algebra.Core.Helpers;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Helpers
{
    public class TypeEnvironment : VarEnvironment<ITypeCheckType>
    {
        public event Action<VarAccessEventArgs> VarAccess;

        private readonly ErrorManager errorManager;

        public TypeEnvironment(ErrorManager errorMngr)
            : base()
        {
            errorManager = errorMngr;
        }

        protected void OnVarAccess(VarAccessEventArgs args)
        {
            if (VarAccess != null)
            {
                VarAccess(args);
            }
        }

        public override void Declare(string name, ITypeCheckType value)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs(name);
            OnVarAccess(eventArgs);

            base.Declare(eventArgs.VarName, value);
        }

        public override bool IsDeclared(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs(name);
            OnVarAccess(eventArgs);

            return base.IsDeclared(eventArgs.VarName);
        }

        public override ITypeCheckType GetDeclared(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs(name);
            OnVarAccess(eventArgs);

            return base.GetDeclared(eventArgs.VarName);
        }

        public override void Clear()
        {
            Debug.Assert(VarAccess == null, "Some events weren't unregistered!");

            base.Clear();
        }

        public void ReportError(string msg, Tuple<int, int> startPos, Tuple<int, int> endPos)
        {
            errorManager.ReportError(msg, startPos, endPos);
        }

        public void ReportWarning(string msg, Tuple<int, int> startPos, Tuple<int, int> endPos)
        {
            errorManager.ReportWarning(msg, startPos, endPos);
        }
    }
}
