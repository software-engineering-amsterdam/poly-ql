using System;
using Algebra.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
    public class VarInitExpr : VarInitExpr<IFormExpr, IFormType>, IFormExpr
    {
        public event Action ValueChanged
        {
            add { Value.ValueChanged += value; }
            remove { Value.ValueChanged -= value; }
        }

        public object ExpressionValue
        {
            get { return Value.ExpressionValue; }
            set { Value.ExpressionValue = value; }
        }

        public VarInitExpr(string name, IFormType type, IFormExpr value)
            : base(name, type, value)
		{
            TypeEnvironment.Instance.DeclareVariable(this);
		}

        public IFormType BuildForm()
        {
            return Type;
        }
    }
}
