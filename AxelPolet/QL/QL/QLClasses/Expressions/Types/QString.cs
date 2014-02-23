using System;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Types
{
    public class QString : QBaseType
    {
        public QString(string field) : base(field)
        {
        }

        public override object GetValue()
        {
            if (_value == null)
                return null;

            return Convert.ToString(_value);
        }

        public override void SetValue(object value)
        {
            _value = value;
        }

        public override Type GetType()
        {
            return typeof(string);
        }

        public override bool CheckType(ref QLException error)
        {
            return true;
        }

        public override object Result()
        {
            return Convert.ToString(_value);
        }
    }
}
