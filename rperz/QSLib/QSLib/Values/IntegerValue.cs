using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Values
{
    public class IntegerValue : Value
    {
        protected int _value;
        private bool _isInput;
        public IntegerValue(int value, bool isInput = false)
        {
            this._isInput = isInput;
            this._value = value;
        }

        public override object GetValue
        {
            get
            {
                return this._value;
            }
        }

        public override void CreateGUI(GUIBuilder guiBuilder)
        {
            if (this._isInput)
                guiBuilder.CreateIntegerInput();
            else
                guiBuilder.CreateIntegerOutput();
        }

        public override Value Add(Value otherValue)
        {
            return otherValue.Add(this);
        }

        public override Value And(Value otherValue)
        {
            return otherValue.And(this);
        }
        public override Value Divide(Value otherValue)
        {
            return otherValue.Divide(this);
        }
        public override Value EqualTo(Value otherValue)
        {
            return otherValue.EqualTo(this);
        }
        public override Value LargerThan(Value otherValue)
        {
            return otherValue.LargerThan(this);
        }
        public override Value LargerThan_Equals(Value otherValue)
        {
            return otherValue.LargerThan_Equals(this);
        }
        public override Value Multiply(Value otherValue)
        {
            return otherValue.Multiply(this);
        }
        public override Value NotEquals(Value otherValue)
        {
            return otherValue.NotEquals(this);
        }
        public override Value Or(Value otherValue)
        {
            return otherValue.Or(this);
        }
        public override Value SmallerThan(Value otherValue)
        {
            return otherValue.SmallerThan(this);
        }
        public override Value SmallerThan_Equals(Value otherValue)
        {
            return otherValue.SmallerThan_Equals(this);
        }
        public override Value Subtract(Value otherValue)
        {
            return otherValue.Subtract(this);
        }

        // double dispatch IntegerValue
        public override Value Add(IntegerValue otherValue)
        {
            return new IntegerValue(this._value + otherValue._value);
        }
        public override Value Divide(IntegerValue otherValue)
        {
            return new IntegerValue(this._value / otherValue._value);
        }
        public override Value EqualTo(IntegerValue otherValue)
        {
            return new BooleanValue(this._value == otherValue._value);
        }
        public override Value LargerThan(IntegerValue otherValue)
        {
            return new BooleanValue(this._value > otherValue._value);
        }
        public override Value LargerThan_Equals(IntegerValue otherValue)
        {
            return new BooleanValue(this._value >= otherValue._value);
        }
        public override Value Multiply(IntegerValue otherValue)
        {
            return new IntegerValue(this._value * otherValue._value);
        }
        public override Value NotEquals(IntegerValue otherValue)
        {
            return new BooleanValue(this._value != otherValue._value);
        }
        public override Value SmallerThan(IntegerValue otherValue)
        {
            return new BooleanValue(this._value < otherValue._value);
        }
        public override Value SmallerThan_Equals(IntegerValue otherValue)
        {
            return new BooleanValue(this._value <= otherValue._value);
        }
        public override Value Subtract(IntegerValue otherValue)
        {
            return new IntegerValue(this._value - otherValue._value);
        }

    }
}
