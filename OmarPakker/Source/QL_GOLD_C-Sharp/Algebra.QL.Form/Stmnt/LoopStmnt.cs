using System;
using System.Collections.Generic;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Extensions.Stmnt;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Stmnt
{
	public class LoopStmnt : LoopStmnt<IFormExpr, IFormStmnt>, IFormStmnt
	{
        private readonly IList<IFormStmnt> bodyClones;

        public LoopStmnt(IFormExpr expr, IFormStmnt body)
            : base(expr, body)
		{
            bodyClones = new List<IFormStmnt>();
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

                for (int i = bodyClones.Count - 1; i >= count; i--)
                {
                    bodyClones[i].Dispose();
                    bodyClones.RemoveAt(i);
                }
            }
            else if (count > sp.Children.Count)
            {
                for (int i = sp.Children.Count; i < count; i++)
                {
                    IFormStmnt bodyClone = Body.Clone();
                    bodyClones.Add(bodyClone);
                    sp.Children.Add(bodyClone.BuildForm());
                }
            }
        }

        public IFormStmnt Clone()
        {
            return new LoopStmnt(Expression.Clone(), Body.Clone());
        }

        public void Dispose()
        {
            Expression.Dispose();
            Body.Dispose();
        }
    }
}
