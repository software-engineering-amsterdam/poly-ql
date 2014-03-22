using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.Core.Helpers;
using Algebra.QL.Extensions.Stmnt;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;

namespace Algebra.QL.Form.Stmnt
{
	public class RepeatStmnt : RepeatStmnt<IFormExpr, IFormStmnt>, IFormStmnt
	{
        public RepeatStmnt(IFormExpr expr, IFormStmnt body)
            : base(expr, body)
		{
            
		}

        public FrameworkElement BuildForm(VarEnvironment env)
        {
            Action<VarAccessEventArgs> onVarAccess = (args) => args.SetVarSuffix("$0");
            env.VarAccess += onVarAccess;
            Body.BuildForm(env);
            env.VarAccess -= onVarAccess;

            StackPanel sp = new StackPanel();

            Action onValueChanged = () => FillChildren(sp, Convert.ToInt32(Expression.Eval(env)), env);
            onValueChanged();

            sp.Loaded += (s, e) => Expression.ValueChanged += onValueChanged;
            sp.Unloaded += (s, e) => Expression.ValueChanged -= onValueChanged;
            
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
                    Action<VarAccessEventArgs> onVarAccess = (args) => args.SetVarSuffix("$" + i);
                    env.VarAccess += onVarAccess;

                    sp.Children.Add(Body.BuildForm(env));

                    env.VarAccess -= onVarAccess;
                }
            }
        }
    }
}
