using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Extensions.Stmnt;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Stmnt;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Extensions.Form.Stmnt
{
    public class RepeatStmnt : RepeatStmnt<IFormExpr, IFormStmnt>, IFormStmnt
    {
        public RepeatStmnt(IFormExpr expr, IFormStmnt body)
            : base(expr, body)
        {
            
        }

        public FrameworkElement BuildForm(ValueEnvironment vEnv, TypeEnvironment tEnv)
        {
            IList<int> baseInstances = null;

            //Need to execute the body atleast once to bring the variable into existance.
            Action<VarAccessEventArgs> onVarAccess = (args) =>
            {
                baseInstances = args.Instances;
                args.SetVarInstance(0);
            };
            vEnv.VarAccess += onVarAccess;
            tEnv.VarAccess += onVarAccess;
            Body.BuildForm(vEnv, tEnv);
            vEnv.VarAccess -= onVarAccess;
            tEnv.VarAccess -= onVarAccess;

            StackPanel sp = new StackPanel();

            ValueContainer value = Expression.Evaluate(vEnv);
            value.ValueChanged += () =>
            {
                Action<VarAccessEventArgs> baseInstancesEvent = (args) => args.SetVarBaseInstances(baseInstances);
                vEnv.VarAccess += baseInstancesEvent;
                tEnv.VarAccess += baseInstancesEvent;
                FillChildren(sp, Convert.ToInt32(value.Value), vEnv, tEnv);
                vEnv.VarAccess -= baseInstancesEvent;
                tEnv.VarAccess -= baseInstancesEvent;
            };
            FillChildren(sp, Convert.ToInt32(value.Value), vEnv, tEnv);

            return sp;
        }

        private void FillChildren(StackPanel sp, int count, ValueEnvironment vEnv, TypeEnvironment tEnv)
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
