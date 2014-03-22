using System;
using Algebra.QL.Core.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr.Literals
{
    public abstract class LiteralExpr<V> : LiteralExpr<IFormType, V>, IFormExpr
    {
        public event Action ValueChanged;

        protected LiteralExpr(V value)
            : base(value)
        {

        }

        public void SetValue(VarEnvironment env, object value)
        {
            Value = (V)value;
            if (ValueChanged != null)
            {
                ValueChanged();
            }
        }

        public object Eval(VarEnvironment env)
        {
            return Value;
        }

        public IFormType BuildForm(VarEnvironment env)
        {
            IFormType type = Type;
            type.SetElementExpression(this);

            return type;
        }
    }
}
