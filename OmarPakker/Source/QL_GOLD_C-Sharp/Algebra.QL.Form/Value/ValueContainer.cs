using System;

namespace Algebra.QL.Form.Value
{
    public class ValueContainer
    {
        public event Action ValueChanged;

        public object Value
        {
            get { return Inactive ? initialValue : actualValue; }
            set
            {
                if (!Inactive)
                {
                    actualValue = value;
                    OnValueChanged();
                }
            }
        }

        public bool Inactive
        {
            get { return isInactive; }
            set
            {
                isInactive = value;
                OnValueChanged();
            }
        }

        private readonly object initialValue;
        private object actualValue;
        private bool isInactive;

        public ValueContainer(object value)
        {
            initialValue = value;
            Value = initialValue;
            isInactive = false;
        }

        private void OnValueChanged()
        {
            if (ValueChanged != null)
            {
                ValueChanged();
            }
        }
    }
}
