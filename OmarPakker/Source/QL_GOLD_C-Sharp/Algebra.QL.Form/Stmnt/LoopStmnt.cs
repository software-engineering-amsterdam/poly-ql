using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Stmnt
{
	public class LoopStmnt : IFormStmnt
	{
		public IFormExpr Expression { get; private set; }
        public IFormStmnt Body { get; private set; }

        public LoopStmnt(IFormExpr expr, IFormStmnt body)
		{
			Expression = expr;
			Body = body;
		}

        public FrameworkElement BuildForm()
        {
            StackPanel sp = new StackPanel();

            Action onValueChanged = () =>
            {
                FillChildren(sp, System.Convert.ToInt32(Expression.ExpressionValue));
            };

            Expression.BuildForm();
            Expression.ValueChanged -= onValueChanged;
            Expression.ValueChanged += onValueChanged;
            onValueChanged();
            
            return sp;
        }

        private void FillChildren(StackPanel sp, int count)
        {
            if (count >= 0 && count < sp.Children.Count)
            {
                //TODO: Remove the ValueChanged events of the removed elements
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
