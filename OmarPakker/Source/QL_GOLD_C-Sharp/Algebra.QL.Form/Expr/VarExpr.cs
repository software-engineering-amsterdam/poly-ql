using System;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
	public class VarExpr : Algebra.Core.Expr.VarExpr, IFormExpr
	{
        public event Action ValueChanged;
        
        public VarExpr(string name)
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
            IFormExpr variable = env.GetDeclared(Name);

            //TODO: Event removal
            variable.ValueChanged -= OnValueChanged;
            variable.ValueChanged += OnValueChanged;
            
            variable.SetValue(env, value);
        }

        public object Eval(VarEnvironment env)
        {
            IFormExpr variable = env.GetDeclared(Name);

            //TODO: Event removal
            variable.ValueChanged -= OnValueChanged;
            variable.ValueChanged += OnValueChanged;

            return variable.Eval(env);
        }

        public IFormType BuildForm(VarEnvironment env)
        {
            IFormType type = env.GetDeclared(Name).BuildForm(env);
            type.SetValue(this);

            return type;
        }
    }
}
