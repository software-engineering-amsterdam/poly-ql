using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Extensions.Stmnt;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;
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

        public FrameworkElement BuildForm(VarEnvironment env)
        {
            Action<VarAccessEventArgs> onVarAccess = (args) => args.SetVarInstance(0);
            env.VarAccess += onVarAccess;
            Body.BuildForm(env);
            env.VarAccess -= onVarAccess;

            StackPanel sp = new StackPanel();

            ValueContainer value = Expression.BuildForm(env);
            value.ValueChanged += () => FillChildren(sp, Convert.ToInt32(value.Value), env);

            return sp;
        }

        private void FillChildren(StackPanel sp, int count, VarEnvironment env)
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
                    env.VarAccess += onVarAccess;
                    sp.Children.Add(Body.BuildForm(env));
                    env.VarAccess -= onVarAccess;
                }
            }
        }
    }
}
