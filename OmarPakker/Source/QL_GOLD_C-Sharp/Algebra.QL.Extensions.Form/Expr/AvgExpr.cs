using System;
using System.Linq;
using Algebra.Core.Collections;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Expr;
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

        public ValueContainer Evaluate(ValueEnvironment env)
        {
            DictionaryKeyValueObserver<string, ValueContainer> repeatVariables = env.GetRange(Name);
            ValueContainer value = new ValueContainer(0);

            Action onValueChanged = () =>
            {
                int count = 0;
                double sum = 0;

                foreach (ValueContainer item in repeatVariables.Where(v => !v.Inactive))
                {
                    count++;
                    sum += Convert.ToDouble(item.Value);
                }

                value.Value = count > 0 ? sum / count : 0;
            };

            Action onCollectionChange = () =>
            {
                foreach (ValueContainer item in repeatVariables)
                {
                    item.ValueChanged += onValueChanged;
                }

                onValueChanged();
            };
            repeatVariables.FilterResultChanged += onCollectionChange;
            onCollectionChange();

            return value;
        }

        public IFormType BuildForm(TypeEnvironment env)
        {
            return new RealType();
        }
    }
}
