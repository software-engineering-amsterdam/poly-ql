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
        public IFormType ExpressionType { get { return Expr1.ExpressionType.GetLeastUpperBound(Expr2.ExpressionType); } }

        public BinaryExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {
            
        }

        public abstract IFormExpr Clone();

        public void Dispose()
        {
            Expr1.Dispose();
            Expr2.Dispose();
        }
    }
}
