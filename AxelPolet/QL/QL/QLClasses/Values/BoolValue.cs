using System.Windows.Controls;
using QL.Interpreter.Controls;

namespace QL.QLClasses.Values
{
    public class BoolValue : QValue
    {
        private readonly bool _value;

        public BoolValue(bool value)
        {
            _value = value;
        }

        public bool GetValue()
        {
            return _value;
        }

        #region Conditionals

        public BoolValue And(BoolValue secondValue)
        {
            return new BoolValue(_value && secondValue.GetValue());
        }

        public BoolValue Or(BoolValue secondValue)
        {
            return new BoolValue(_value || secondValue.GetValue());
        }

        #endregion
    }
}
