using System.Windows.Controls;
using QL.Interpreter.Controls;

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
    }
}
