using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;
using Algebra.QL.Extensions.Environment;
using Algebra.QL.Extensions.Stmnt;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Stmnt;

namespace Algebra.QL.Extensions.Form.Stmnt
{
    public class RepeatStmnt : RepeatStmnt<IFormExpr, IFormStmnt>, IFormStmnt
    {
        public RepeatStmnt(IFormExpr expr, IFormStmnt body)
            : base(expr, body)
        {
            
        }

        public FrameworkElement BuildForm(IValueEnvironment vEnv, ITypeEnvironment tEnv)
        {
            IList<int> baseInstances = null;

            //TODO: Make it so no casting is needed
            Eval.Environment.ValueEnvironment vEnvExt = (Eval.Environment.ValueEnvironment)vEnv;
            Environment.TypeEnvironment tEnvExt = (Environment.TypeEnvironment)tEnv;

            //Need to execute the body atleast once to bring the variable into existance.
            Action<VarAccessEventArgs> onVarAccess = (args) =>
            {
                baseInstances = args.Instances;
                args.SetVarInstance(0);
            };
            vEnvExt.VarAccess += onVarAccess;
            tEnvExt.VarAccess += onVarAccess;
            Body.BuildForm(vEnv, tEnv);
            vEnvExt.VarAccess -= onVarAccess;
            tEnvExt.VarAccess -= onVarAccess;

            StackPanel sp = new StackPanel();

            ValueContainer value = Expression.Evaluate(vEnv);
            value.ValueChanged += () =>
            {
                Action<VarAccessEventArgs> baseInstancesEvent = (args) => args.SetVarBaseInstances(baseInstances);
                vEnvExt.VarAccess += baseInstancesEvent;
                tEnvExt.VarAccess += baseInstancesEvent;
                FillChildren(sp, Convert.ToInt32(value.Value), vEnvExt, tEnvExt);
                vEnvExt.VarAccess -= baseInstancesEvent;
                tEnvExt.VarAccess -= baseInstancesEvent;
            };
            FillChildren(sp, Convert.ToInt32(value.Value), vEnvExt, tEnvExt);

            return sp;
        }

        private void FillChildren(StackPanel sp, int count, Eval.Environment.ValueEnvironment vEnv, Environment.TypeEnvironment tEnv)
        {
            if (count >= 0 && count < sp.Children.Count)
            {
                sp.Children.RemoveRange(count, sp.Children.Count - count);
            }
            else if (count > sp.Children.Count)
            {
                for (int i = sp.Children.Count; i < count; i++)
                {
                    Action<VarAccessEventArgs> onVarAccess = (args) => args.SetVarInstance(i);
                    vEnv.VarAccess += onVarAccess;
                    tEnv.VarAccess += onVarAccess;
                    sp.Children.Add(Body.BuildForm(vEnv, tEnv));
                    vEnv.VarAccess -= onVarAccess;
                    tEnv.VarAccess -= onVarAccess;
                }
            }
        }
    }
}
