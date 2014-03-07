using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public abstract class BinaryExpr : BinaryExpr<IFormExpr>, IFormExpr
    {
        public event Action ValueChanged;
        public abstract object ExpressionValue { get; set; }

        public BinaryExpr(IFormExpr l, IFormExpr r)
            : base(l, r)
        {
            
        }

        private void OnValueChanged()
        {
            if (ValueChanged != null)
            {
                ValueChanged();
            }
        }

        public IFormType BuildForm()
        {
            IFormType a = Expr1.BuildForm();
            IFormType b = Expr2.BuildForm();

            Expr1.ValueChanged -= OnValueChanged;
            Expr2.ValueChanged -= OnValueChanged;
            Expr1.ValueChanged += OnValueChanged;
            Expr2.ValueChanged += OnValueChanged;

            return a.GetLeastUpperBound(b);
        }
    }
}
