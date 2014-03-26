using System;
using System.Diagnostics;
using Algebra.Core.Environment;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Environment
{
    public class TypeEnvironment : VarEnvironment<ITypeCheckType>
    {
        private const char RepeatedSuffix = '$';

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

        protected string VarNameToInstancedName(string name, int repeatCount)
        {
            for (int i = 0; i < repeatCount; i++)
            {
                name += RepeatedSuffix;
            }

            return name;
        }

        public override void Declare(string name, ITypeCheckType value)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            base.Declare(VarNameToInstancedName(name, eventArgs.RepeatCount), value);
        }

        public override bool IsDeclared(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            if (eventArgs.IsInstanced)
            {
                for (int i = eventArgs.RepeatCount; i > 0; i--)
                {
                    if (base.IsDeclared(VarNameToInstancedName(name, i)))
                    {
                        return true;
                    }
                }
            }

            return base.IsDeclared(name);
        }

        public override ITypeCheckType GetDeclared(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs();
            OnVarAccess(eventArgs);

            if (eventArgs.IsInstanced)
            {
                for (int i = eventArgs.RepeatCount; i > 0; i--)
                {
                    if (base.IsDeclared(VarNameToInstancedName(name, i)))
                    {
                        return base.GetDeclared(VarNameToInstancedName(name, i));
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
