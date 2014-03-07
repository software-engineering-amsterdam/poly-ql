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
            Expression.BuildForm();
            FillChildren(sp, System.Convert.ToInt32(Expression.ExpressionValue));

            Expression.ValueChanged += () =>
            {
                FillChildren(sp, System.Convert.ToInt32(Expression.ExpressionValue));
            };
            
            return sp;
        }

        private void FillChildren(StackPanel sp, int count)
        {
            sp.Children.Clear();
            for(int i = 0; i < count; i++)
            {
                //TODO: fix value of looped variables
                sp.Children.Add(Body.BuildForm());
            }
        }
    }
}
