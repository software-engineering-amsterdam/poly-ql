using System;
using System.Collections.Generic;
using System.Linq;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Extensions.Form.Expr
{
    public class SumExpr : Algebra.Core.Expr.VarExpr, IFormExpr
    {
        public event Action ValueChanged;

        public SumExpr(string name)
            : base(name)
        {
            
        }

        private void OnValueChanged()
        {
            if (ValueChanged != null)
            {
                ValueChanged();
            }
        }

        public void SetValue(VarEnvironment env, object value)
        {

        }

        public object Eval(VarEnvironment env)
        {
            IEnumerable<IFormExpr> repeatVariables = env.GetRange(Name);

            double sum = 0;

            foreach (IFormExpr expr in repeatVariables)
            {
                sum += Convert.ToDouble(expr.Eval(env));

                //TODO: Event removal
                expr.ValueChanged -= OnValueChanged;
                expr.ValueChanged += OnValueChanged;
            }

            return sum;
        }

        public IFormType BuildForm(VarEnvironment env)
        {
            IFormType type = env.GetRange(Name).First().BuildForm(env);
            type.SetElementExpression(this);

            return type;
        }
    }
}
