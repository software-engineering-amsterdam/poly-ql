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

        public IFormType ExpressionType { get { return Expr2.ExpressionType.GetLeastUpperBound(Expr3.ExpressionType); } }

        public IfElseExpr(IFormExpr a, IFormExpr b, IFormExpr c)
            : base(a, b, c)
        {
            
        }

        public IFormExpr Clone()
        {
            return new IfElseExpr(Expr1.Clone(), Expr2.Clone(), Expr3.Clone());
        }

        public void Dispose()
        {
            Expr1.Dispose();
            Expr2.Dispose();
            Expr3.Dispose();
        }
    }
}
