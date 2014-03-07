using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class VarInitExpr : VarInitExpr<IFormExpr, IFormType>, IFormExpr
    {
        public event Action ValueChanged;
        public object ExpressionValue
        {
            get { return Value.ExpressionValue; }
            set { Value.ExpressionValue = value; }
        }

        public VarInitExpr(string name, IFormType type, IFormExpr value)
            : base(name, type, value)
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
            TypeEnvironment.Instance.DeclareVariable(this);

            Value.BuildForm();

            Value.ValueChanged -= OnValueChanged;
            Value.ValueChanged += OnValueChanged;

            return Type;
        }
    }
}
