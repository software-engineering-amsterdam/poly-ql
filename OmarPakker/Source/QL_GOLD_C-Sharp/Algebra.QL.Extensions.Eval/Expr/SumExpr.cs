using System;
using System.Linq;
using Algebra.Core.Collections;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Expr;
using Algebra.QL.Eval.Value;

namespace Algebra.QL.Extensions.Eval.Expr
{
    public class SumExpr : Algebra.Core.Expr.VarExpr, IEvalExpr
    {
        public SumExpr(string name)
            : base(name)
        {
            
        }

        public ValueContainer Evaluate(ValueEnvironment env)
        {
            DictionaryKeyValueObserver<string, ValueContainer> repeatVariables = env.GetRange(Name);
            ValueContainer value = new ValueContainer(0);

            Action onValueChanged = () =>
            {
                double sum = 0;

                foreach (ValueContainer item in repeatVariables.Where(v => !v.Inactive))
                {
                    sum += Convert.ToDouble(item.Value);
                }

                value.Value = sum;
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
    }
}
