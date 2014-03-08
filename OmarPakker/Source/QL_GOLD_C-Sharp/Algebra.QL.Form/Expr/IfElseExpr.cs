using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class IfElseExpr : TernaryExpr<IFormExpr>, IFormExpr
    {
        public event Action ValueChanged
        {
            add { Expr1.ValueChanged += value; Expr2.ValueChanged += value; Expr3.ValueChanged += value; }
            remove { Expr1.ValueChanged -= value; Expr2.ValueChanged -= value; Expr3.ValueChanged -= value; }
        }

        public object ExpressionValue
        {
            get { return (bool)Expr1.ExpressionValue ? Expr2.ExpressionValue : Expr3.ExpressionValue; }
            set { }
        }

        public IfElseExpr(IFormExpr a, IFormExpr b, IFormExpr c)
            : base(a, b, c)
        {
            
        }

        public IFormType BuildForm()
        {
            Expr1.BuildForm();
            IFormType a = Expr2.BuildForm();
            IFormType b = Expr3.BuildForm();

            return a.GetLeastUpperBound(b);
        }
    }
}
