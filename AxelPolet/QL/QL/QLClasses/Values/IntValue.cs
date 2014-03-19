using QL.Interpreter.Controls.Input;

namespace QL.QLClasses.Values
{
    public class IntValue : QValue
    {
        private readonly int _value;

        public IntValue(int value)
        {
            _value = value;
        }
        
        public int Value()
        {
            return _value;
        }

        #region Math

        public IntValue Add(IntValue secondValue)
        {
            return new IntValue(_value + secondValue.Value());
        }

        public IntValue Div(IntValue secondValue)
        {
            return new IntValue(_value / secondValue.Value());
        }

        public IntValue Sub(IntValue secondValue)
        {
            return new IntValue(_value - secondValue.Value());
        }

        public IntValue Mul(IntValue secondValue)
        {
            return new IntValue(_value * secondValue.Value());
        }

        #endregion

        #region Compares

        public BoolValue Equals(IntValue secondValue)
        {
            return new BoolValue(_value == secondValue.Value());
        }

        public BoolValue GrTh(IntValue secondValue)
        {
            return new BoolValue(_value > secondValue.Value());
        }

        public BoolValue GrThEq(IntValue secondValue)
        {
            return new BoolValue(_value >= secondValue.Value());
        }

        public BoolValue SmTh(IntValue secondValue)
        {
            return new BoolValue(_value < secondValue.Value());
        }

        public BoolValue SmThEq(IntValue secondValue)
        {
            return new BoolValue(_value <= secondValue.Value());
        }

        #endregion

        #region GUI Method Implementation

        public override InputControl CreateInputControl(string name, QLMemory memory, bool isComputed)
        {
            return new IntTextBoxControl(name, memory, isComputed);
        }

        #endregion
    }
}
