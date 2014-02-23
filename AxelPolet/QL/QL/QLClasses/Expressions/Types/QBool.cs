using System;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Types
{
    public class QBool : QBaseType
    {
        public QBool(string field) : base(field)
        {
        }

        public override object GetValue()
        {
            if (_value == null)
                return null;

            return Convert.ToBoolean(_value);
        }

        public override void SetValue(object value)
        {
            if (value == null || String.IsNullOrEmpty(value.ToString()))
                _value = null;
            else
                _value = value;
        }

        public override Type GetType()
        {
            return typeof (bool);
        }

        public override bool CheckType(ref QLException error)
        {
            bool value;
            if (_value != null && !Boolean.TryParse(_value.ToString(), out value))
            {
                error.TokenLine = TokenLine;
                error.TokenColumn = TokenColumn;
                error.TokenText = TokenText;
                error.Message = string.Format("(QBool) Assigned value is not a boolean! InnerValue: '{0}'", _value);

                return false;
            }

            return true;
        }

        public override object Result()
        {
            return Convert.ToBoolean(_value);
        }
    }
}
