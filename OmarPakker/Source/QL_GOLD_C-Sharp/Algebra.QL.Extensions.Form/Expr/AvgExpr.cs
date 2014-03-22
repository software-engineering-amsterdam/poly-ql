using System;
using System.Collections.Generic;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Extensions.Form.Expr
{
    public class AvgExpr : Algebra.Core.Expr.VarExpr, IFormExpr
    {
        public event Action ValueChanged;

        public AvgExpr(string name)
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

            int count = 0;
            double sum = 0;

            foreach (IFormExpr expr in repeatVariables)
            {
                count++;
                sum += Convert.ToDouble(expr.Eval(env));
                
                //TODO: Event removal
                expr.ValueChanged -= OnValueChanged;
                expr.ValueChanged += OnValueChanged;
            }

            return count > 0 ? sum / count : 0;
        }

        public IFormType BuildForm(VarEnvironment env)
        {
            IFormType type = new RealType();
            type.SetElementExpression(this);

            return type;
        }
    }
}
