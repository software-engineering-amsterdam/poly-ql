using QL.Interpreter.Controls.Input;

namespace QL.QLClasses.Values
{
    public class StringValue : QValue
    {
        private readonly string _value;

        public StringValue(string value)
        {
            _value = value;
        }

        public string GetValue()
        {
            return _value;
        }

        #region GUI Method Implementation

        public override InputControl CreateInputControl(string name, QLMemory memory, bool isComputed)
        {
            return new StringTextBoxControl(name, memory, isComputed);
        }

        #endregion
    }
}
