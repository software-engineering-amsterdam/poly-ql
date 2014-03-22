using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using Algebra.Core.Helpers;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Helpers
{
    public class VarEnvironment : VarEnvironment<IFormExpr>
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

        public override void Declare(string name, IFormExpr value)
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

        public override IFormExpr GetDeclared(string name)
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

        public virtual bool IsRepeated(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs(name);
            OnVarAccess(eventArgs);

            return Variables.Keys.Any(k => k.StartsWith(eventArgs.VarName + RepeatedSuffix));
        }

        public virtual bool HasSiblings(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs(name);
            OnVarAccess(eventArgs);

            int signIndex = eventArgs.VarName.LastIndexOf(RepeatedSuffix);
            if (signIndex < 0)
            {
                return false;
            }

            string siblingsStart = eventArgs.VarName.Substring(0, signIndex + 1);

            return Variables.Keys.Any(k => k.StartsWith(siblingsStart));
        }

        public virtual IEnumerable<IFormExpr> GetRange(string name)
        {
            VarAccessEventArgs eventArgs = new VarAccessEventArgs(name);
            OnVarAccess(eventArgs);

            string suffixedName = eventArgs.VarName + RepeatedSuffix;

            return Variables.Where(kv => kv.Key.StartsWith(suffixedName)).Select(kv => kv.Value).ToList();
        }
    }
}
