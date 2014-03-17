using QL.Interpreter.Controls.Input;

namespace QL.QLClasses.Values
{
    public abstract class QValue
    {
        public abstract InputControl CreateInputControl(string name, QLMemory memory, bool isComputed);
    }
}