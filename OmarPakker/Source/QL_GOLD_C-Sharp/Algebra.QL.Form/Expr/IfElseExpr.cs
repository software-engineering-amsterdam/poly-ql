using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class IfElseExpr : TernaryExpr<IFormExpr>, IFormExpr
    {
        public event Action ValueChanged;
        public object ExpressionValue
        {
            get { return (bool)Expr1.ExpressionValue ? Expr2.ExpressionValue : Expr3.ExpressionValue; }
            set { }
        }

        public IfElseExpr(IFormExpr a, IFormExpr b, IFormExpr c)
            : base(a, b, c)
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
            Expr1.BuildForm();
            IFormType a = Expr2.BuildForm();
            IFormType b = Expr3.BuildForm();

            Expr1.ValueChanged -= OnValueChanged;
            Expr2.ValueChanged -= OnValueChanged;
            Expr3.ValueChanged -= OnValueChanged;
            Expr1.ValueChanged += OnValueChanged;
            Expr2.ValueChanged += OnValueChanged;
            Expr3.ValueChanged += OnValueChanged;

            return a.GetLeastUpperBound(b);
        }
    }
}
