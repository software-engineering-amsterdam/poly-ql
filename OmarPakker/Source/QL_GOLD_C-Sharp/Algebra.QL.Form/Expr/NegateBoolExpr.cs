using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
	public class NegateBoolExpr : UnaryExpr<IFormExpr>, IFormExpr
	{
        public event Action ValueChanged;
        public object ExpressionValue
        {
            get { return !(bool)Expr1.ExpressionValue; }
            set { Expr1.ExpressionValue = !(bool)value; }
        }

        public NegateBoolExpr(IFormExpr expr)
            : base(expr)
		{
            
		}

        public IFormType BuildForm()
        {
            Expr1.ValueChanged += () =>
            {
                if (ValueChanged != null)
                {
                    ValueChanged();
                }
            };

            return Expr1.BuildForm();
        }
    }
}
