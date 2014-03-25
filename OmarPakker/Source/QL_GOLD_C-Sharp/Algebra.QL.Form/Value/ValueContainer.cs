using System;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Value
{
    public class ValueContainer
    {
        public event Action ValueChanged;

        public IFormType ValueType { get; private set; }
        public object Value
        {
            get { return actualValue; }
            set
            {
                actualValue = value;
                if (ValueChanged != null)
                {
                    ValueChanged();
                }
            }
        }

        private object actualValue;

        public ValueContainer(IFormType type, object initialValue)
        {
            ValueType = type;
            Value = initialValue;
        }
    }
}
