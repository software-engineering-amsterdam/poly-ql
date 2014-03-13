using QL.Interpreter.Controls;

namespace QL.QLClasses.Values
{
    public class IntValue : QValue
    {
        private readonly int _value;

        public IntValue(int value)
        {
            _value = value;
        }
        
        public int GetValue()
        {
            return _value;
        }

        #region Math

        public IntValue Add(IntValue secondValue)
        {
            return new IntValue(_value + secondValue.GetValue());
        }

        public IntValue Div(IntValue secondValue)
        {
            return new IntValue(_value + secondValue.GetValue());
        }

        public IntValue Sub(IntValue secondValue)
        {
            return new IntValue(_value - secondValue.GetValue());
        }

        public IntValue Mul(IntValue secondValue)
        {
            return new IntValue(_value * secondValue.GetValue());
        }

        #endregion

        #region Compares

        public BoolValue Equals(IntValue secondValue)
        {
            return new BoolValue(_value == secondValue.GetValue());
        }

        public BoolValue GrTh(IntValue secondValue)
        {
            return new BoolValue(_value > secondValue.GetValue());
        }

        public BoolValue GrThEq(IntValue secondValue)
        {
            return new BoolValue(_value >= secondValue.GetValue());
        }

        public BoolValue SmTh(IntValue secondValue)
        {
            return new BoolValue(_value < secondValue.GetValue());
        }

        public BoolValue SmThEq(IntValue secondValue)
        {
            return new BoolValue(_value <= secondValue.GetValue());
        }

        #endregion
    }
}
