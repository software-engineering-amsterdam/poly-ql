using System;

namespace Algebra.QL.Form.Value
{
    public class ValueContainer
    {
        public event Action ValueChanged;

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

        public ValueContainer(object initialValue)
        {
            Value = initialValue;
        }
    }
}
