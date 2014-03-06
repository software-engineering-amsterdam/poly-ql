using System;
using System.ComponentModel;
using System.Diagnostics;
using System.Windows;
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

        public IFormType BuildForm()
        {
            //TODO: Binary Expressions should return the upper bound type
            IFormType a = Expr1.BuildForm();
            IFormType b = Expr2.BuildForm();

            Action onValueChanged = () =>
            {
                if (ValueChanged != null)
                {
                    ValueChanged();
                }
            };
            Expr1.ValueChanged += onValueChanged;
            Expr2.ValueChanged += onValueChanged;

            return a;
        }
    }
}
