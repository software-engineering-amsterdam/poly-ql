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

        public IFormType BuildForm()
        {
            Expr1.BuildForm();
            //TODO: If/Else should return the upperbound type
            IFormType a = Expr2.BuildForm();
            IFormType b = Expr3.BuildForm();

            Action onValueChanged = () =>
            {
                if (ValueChanged != null)
                {
                    ValueChanged();
                }
            };
            Expr1.ValueChanged += onValueChanged;
            Expr2.ValueChanged += onValueChanged;
            Expr3.ValueChanged += onValueChanged;

            return a;
        }
    }
}
