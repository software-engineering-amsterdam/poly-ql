using System;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions.Types
{
    public class QInt : QBaseType
    {
        public QInt(string field) : base(field)
        {
        }

        public override object GetValue()
        {
            if (_value == null)
                return null;

            return Convert.ToInt32(_value);
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
            return typeof(int);
        }

        public override bool CheckType(ref QLException error)
        {
            int result;
            if (_value != null && !Int32.TryParse(_value.ToString(), out result))
            {
                error.TokenLine = TokenLine;
                error.TokenColumn = TokenColumn;
                error.TokenText = TokenText;
                error.Message = string.Format("(QInt) Assigned value is not a integer! Got '{0}'", _value);

                return false;
            }

            return true;
        }

        public override object Result()
        {
            return Convert.ToInt32(_value);
        }
    }
}
