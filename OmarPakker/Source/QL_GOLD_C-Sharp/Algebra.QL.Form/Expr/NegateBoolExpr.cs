using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
	public class NegateBoolExpr : UnaryExpr<IFormExpr>, IFormExpr
	{
        public event Action ValueChanged
        {
            add { Expr1.ValueChanged += value; }
            remove { Expr1.ValueChanged -= value; }
        }

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
            return Expr1.BuildForm();
        }
    }
}
