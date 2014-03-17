using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Values
{
    public class IntegerValue : Value
    {
        protected int _value;
        public IntegerValue(int value)
        {
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
            guiBuilder.CreateIntegerIO();
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
