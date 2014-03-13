using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
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
        private readonly int originalIndex;

        private VarInitExpr(VarInitExpr copy)
            : base(copy.Name, copy.Type, copy.Value.Clone())
        {
            variables = copy.variables;
        }

        public VarInitExpr(string name, IFormType type, IFormExpr value, IDictionary<string, ObservableCollection<IFormExpr>> vars)
            : base(name, type, value)
		{
            if (!vars.ContainsKey(Name))
            {
                vars.Add(Name, new ObservableCollection<IFormExpr>());
            }

            originalIndex = vars[Name].Count;
            vars[Name].Add(this);
            vars[Name].Add(this);
            variables = vars;
		}

        public IFormExpr Clone()
        {
            VarInitExpr newSelf = new VarInitExpr(Name, Type, Value.Clone(), variables);

            bool isNumber = variables[Name][0].ExpressionType.GetLeastUpperBound(new RealType()).Equals(new RealType());

            int changeIndex = originalIndex + 1;
            variables[Name][changeIndex] = isNumber ? new AddExpr(variables[Name][changeIndex], newSelf)
                : (IFormExpr)new AndExpr(variables[Name][changeIndex], newSelf);

            variables[Name][1] = variables[Name][0];
            for (int i = variables[Name].Count - 2; i > 0; i -= 2)
            {
                variables[Name][1] = isNumber ? new AddExpr(variables[Name][1], variables[Name][i])
                    : (IFormExpr)new AndExpr(variables[Name][1], variables[Name][i]);
            }

            return newSelf;
        }

        public void Dispose()
        {
            Debug.Assert(originalIndex == variables[Name].Count - 2);

            variables[Name].RemoveAt(originalIndex + 1);
            variables[Name].RemoveAt(originalIndex);
            variables[Name][variables[Name].Count - 1] = variables[Name][variables[Name].Count - 2];

            bool isNumber = variables[Name][0].ExpressionType.GetLeastUpperBound(new RealType()).Equals(new RealType());

            variables[Name][1] = variables[Name][0];
            for (int i = variables[Name].Count - 2; i > 0; i -= 2)
            {
                variables[Name][1] = isNumber ? new AddExpr(variables[Name][1], variables[Name][i])
                    : (IFormExpr)new AndExpr(variables[Name][1], variables[Name][i]);
            }
        }
    }
}
