using QL.Interpreter.Controls.Input;

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

        #region GUI Method Implementation

        public override InputControl CreateInputControl(string name, QLMemory memory, bool isComputed)
        {
            return new CheckBoxControl(name, memory, isComputed);
        }

        #endregion
    }
}
