using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public abstract class BinaryExpr : BinaryExpr<IFormExpr>, IFormExpr
    {
        public event Action ValueChanged
        {
            add { Expr1.ValueChanged += value; Expr2.ValueChanged += value; }
            remove { Expr1.ValueChanged -= value; Expr2.ValueChanged -= value; }
        }

        public abstract object ExpressionValue { get; set; }

        public BinaryExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {
            
        }

        public IFormType BuildForm()
        {
            IFormType a = Expr1.BuildForm();
            IFormType b = Expr2.BuildForm();

            return a.GetLeastUpperBound(b);
        }
    }
}
