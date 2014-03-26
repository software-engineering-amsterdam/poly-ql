using System;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Extensions.Form.Expr
{
    public class SumExpr : Algebra.Core.Expr.VarExpr, IFormExpr
    {
        public SumExpr(string name)
            : base(name)
        {
            
        }

        public ValueContainer Evaluate(ValueEnvironment env)
        {
            ObservableCollection<ValueContainer> repeatVariables = env.GetRange(Name);
            ValueContainer value = new ValueContainer(0);

            Action onValueChanged = () =>
            {
                double sum = 0;

                foreach (ValueContainer item in repeatVariables)
                {
                    sum += Convert.ToDouble(item.Value);
                }

                value.Value = sum;
            };
            onValueChanged();

            NotifyCollectionChangedEventHandler onCollectionChange = (s, e) =>
            {
                foreach (ValueContainer item in repeatVariables)
                {
                    item.ValueChanged += onValueChanged;
                }

                onValueChanged();
            };
            repeatVariables.CollectionChanged += onCollectionChange;
            onCollectionChange(null, null);

            return value;
        }

        public IFormType BuildForm(TypeEnvironment env)
        {
            return env.GetRange(Name)[0];
        }
    }
}
