using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using Algebra.Core.Expr;
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

        public IFormType ExpressionType { get { return Type; } }

        private readonly IDictionary<string, ObservableCollection<IFormExpr>> variables;

        public VarInitExpr(string name, IFormType type, IFormExpr value, IDictionary<string, ObservableCollection<IFormExpr>> vars)
            : base(name, type, value)
		{
            if (!vars.ContainsKey(Name))
            {
                vars.Add(Name, new ObservableCollection<IFormExpr>() { this });
            }
            vars[Name].Add(this);
            variables = vars;
		}

        public IFormExpr Clone()
        {
            VarInitExpr newSelf = new VarInitExpr(Name, Type, Value.Clone(), variables);

            variables[Name][1] = variables[Name][1].ExpressionType.GetLeastUpperBound(new RealType()).Equals(new RealType())
                ? (IFormExpr)new AddExpr(variables[Name][1], newSelf)
                : (IFormExpr)new AndExpr(variables[Name][1], newSelf);

            return newSelf;
        }

        public void Dispose()
        {
            if (variables[Name].IndexOf(this) > 0) variables[Name].Remove(this);

            bool isNumber = variables[Name][1].ExpressionType.GetLeastUpperBound(new RealType()).Equals(new RealType());
            IFormExpr oldVar = variables[Name][1];
            variables[Name][1] = variables[Name][0];

            for (int i = 2; i < variables[Name].Count; i++)
            {
                variables[Name][1] = isNumber ? new AddExpr(variables[Name][1], variables[Name][i])
                    : (IFormExpr)new AndExpr(variables[Name][1], variables[Name][i]);
            }
        }
    }
}
