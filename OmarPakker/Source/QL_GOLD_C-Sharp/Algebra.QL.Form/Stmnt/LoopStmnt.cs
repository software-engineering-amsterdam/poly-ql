using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Extensions.Stmnt;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Stmnt
{
	public class LoopStmnt : LoopStmnt<IFormExpr, IFormStmnt>, IFormStmnt
	{
        public LoopStmnt(IFormExpr expr, IFormStmnt body)
            : base(expr, body)
		{

		}

        public FrameworkElement BuildForm()
        {
            StackPanel sp = new StackPanel();

            Action onValueChanged = () =>
            {
                FillChildren(sp, System.Convert.ToInt32(Expression.ExpressionValue));
            };
            onValueChanged();

            sp.Loaded += (s, e) => Expression.ValueChanged += onValueChanged;
            sp.Unloaded += (s, e) => Expression.ValueChanged -= onValueChanged;
            
            return sp;
        }

        private void FillChildren(StackPanel sp, int count)
        {
            if (count >= 0 && count < sp.Children.Count)
            {
                sp.Children.RemoveRange(count, sp.Children.Count - count);
            }
            else if (count > sp.Children.Count)
            {
                for (int i = sp.Children.Count; i < count; i++)
                {
                    //TODO: fix value of looped variables
                    sp.Children.Add(Body.BuildForm());
                }
            }
        }
    }
}
