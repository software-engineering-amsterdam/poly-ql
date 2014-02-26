using System;

namespace QL.QLClasses.Expressions.Types
{
    public abstract class QBaseType : ExpressionBase
    {
        protected object _value;

        public QBaseType(object field)
        {
            SetValue(field);
        }

        public abstract object GetValue();
        public abstract void SetValue(object value);
    }
}