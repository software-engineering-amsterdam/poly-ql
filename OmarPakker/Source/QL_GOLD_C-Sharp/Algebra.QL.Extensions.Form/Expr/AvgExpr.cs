using System;
using System.Collections.ObjectModel;
using System.Collections.Specialized;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Helpers;
using Algebra.QL.Form.Type;
using Algebra.QL.Form.Value;

namespace Algebra.QL.Extensions.Form.Expr
{
    public class AvgExpr : Algebra.Core.Expr.VarExpr, IFormExpr
    {
        public AvgExpr(string name)
            : base(name)
        {
            
        }

        public ValueContainer BuildForm(VarEnvironment env)
        {
            ObservableCollection<ValueContainer> repeatVariables = env.GetRange(Name);
            ValueContainer value = new ValueContainer(new RealType(), 0);

            Action onValueChanged = () =>
            {
                int count = 0;
                double sum = 0;

                foreach (ValueContainer item in repeatVariables)
                {
                    count++;
                    sum += Convert.ToDouble(item.Value);
                }

                value.Value = count > 0 ? sum / count : 0;
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
    }
}
