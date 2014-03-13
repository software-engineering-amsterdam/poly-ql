using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Expr
{
	public class VarExpr : Algebra.Core.Expr.VarExpr, IFormExpr
	{
        public event Action ValueChanged;
        
        public object ExpressionValue
        {
            get { return realVariable.ExpressionValue; }
            set { realVariable.ExpressionValue = value; }
        }

        public IFormType ExpressionType { get { return realVariable.ExpressionType; } }

        private int myIndex;
        private IFormExpr realVariable;
        private readonly IDictionary<string, ObservableCollection<IFormExpr>> variables;

        public VarExpr(string name, IDictionary<string, ObservableCollection<IFormExpr>> vars)
			: base(name)
		{
            myIndex = vars[Name].Count - 1;
            realVariable = vars[Name][myIndex];

            vars[Name].CollectionChanged += VarExpr_CollectionChanged;

            variables = vars;

            realVariable.ValueChanged += OnValueChanged;
		}

        private void VarExpr_CollectionChanged(object sender, NotifyCollectionChangedEventArgs e)
        {
            if (e.OldStartingIndex == myIndex && e.NewStartingIndex >= 0)
            {
                myIndex = e.NewStartingIndex;
                realVariable = ((ObservableCollection<IFormExpr>)sender)[myIndex];
                realVariable.ValueChanged += OnValueChanged;
                OnValueChanged();
            }
        }

        private void OnValueChanged()
        {
            if (ValueChanged != null)
            {
                ValueChanged();
            }
        }

        public IFormExpr Clone()
        {
            return new VarExpr(Name, variables);
        }

        public void Dispose()
        {
            myIndex = 0;
            variables[Name].CollectionChanged -= VarExpr_CollectionChanged;
            realVariable.ValueChanged -= OnValueChanged;
        }
    }
}
