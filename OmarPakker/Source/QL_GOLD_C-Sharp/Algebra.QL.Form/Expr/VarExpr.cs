using System;
using System.ComponentModel;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
	public class VarExpr : Algebra.Core.Expr.VarExpr, IFormExpr
	{
        public event Action ValueChanged
        {
            add { actualVar.ValueChanged += value; }
            remove { actualVar.ValueChanged -= value; }
        }
        
        public object ExpressionValue
        {
            get { return actualVar.Value.ExpressionValue; }
            set { actualVar.Value.ExpressionValue = value; }
        }

        private VarInitExpr actualVar;

		public VarExpr(string name)
			: base(name)
		{
            actualVar = TypeEnvironment.Instance.GetVariable(Name);
		}

        public IFormType BuildForm()
        {
            return actualVar.BuildForm();
        }
    }
}
