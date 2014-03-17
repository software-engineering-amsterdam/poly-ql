using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Values
{
    public abstract class Value
    {
        public abstract object GetValue { get; }
        public abstract void CreateGUI(GUIBuilder guiBuilder);

        public virtual Value Add(Value otherValue)
        {
            return otherValue.Add(this);
        }

        public virtual Value And(Value otherValue)
        {
            return otherValue.And(this);
        }
        public virtual Value Divide(Value otherValue)
        {
            return otherValue.Divide(this);
        }
        public virtual Value EqualTo(Value otherValue)
        {
            return otherValue.EqualTo(this);
        }
        public virtual Value LargerThan(Value otherValue)
        {
            return otherValue.LargerThan(this);
        }
        public virtual Value LargerThan_Equals(Value otherValue)
        {
            return otherValue.LargerThan_Equals(this);
        }
        public virtual Value Multiply(Value otherValue)
        {
            return otherValue.Multiply(this);
        }
        public virtual Value NotEquals(Value otherValue)
        {
            return otherValue.NotEquals(this);
        }
        public virtual Value Or(Value otherValue)
        {
            return otherValue.Or(this);
        }
        public virtual Value SmallerThan(Value otherValue)
        {
            return otherValue.SmallerThan(this);
        }
        public virtual Value SmallerThan_Equals(Value otherValue)
        {
            return otherValue.SmallerThan_Equals(this);
        }
        public virtual Value Subtract(Value otherValue)
        {
            return otherValue.Subtract(this);
        }

        public virtual Value Not()
        {
            throw new Exception("Not operator used on non-bool value");
        }


        // double dispatch BooleanValue
        public virtual Value Add(BooleanValue otherValue)
        {
            throw new Exception("Add operator used on bool value");
        }

        public virtual Value And(BooleanValue otherValue)
        {
            throw new Exception("And operator used on non-bool value");
        }
        public virtual Value Divide(BooleanValue otherValue)
        {
            throw new Exception("Divide operator used on bool value");
        }
        public virtual Value EqualTo(BooleanValue otherValue)
        {
            throw new Exception("Equals operator used on non-bool and non-integer value");
        }
        public virtual Value LargerThan(BooleanValue otherValue)
        {
            throw new Exception("Larger than operator used on bool value");
        }
        public virtual Value LargerThan_Equals(BooleanValue otherValue)
        {
            throw new Exception("Larger than or equals operator used on bool value");
        }
        public virtual Value Multiply(BooleanValue otherValue)
        {
            throw new Exception("Multiply operator used on bool value");
        }
        public virtual Value NotEquals(BooleanValue otherValue)
        {
            throw new Exception("Not equals operator used on non-bool and non-integer value");
        }
        public virtual Value Or(BooleanValue otherValue)
        {
            throw new Exception("Or operator used on non-bool value");
        }
        public virtual Value SmallerThan(BooleanValue otherValue)
        {
            throw new Exception("Smaller than operator used on bool value");
        }
        public virtual Value SmallerThan_Equals(BooleanValue otherValue)
        {
            throw new Exception("Smaller than or equals operator used on bool value");
        }
        public virtual Value Subtract(BooleanValue otherValue)
        {
            throw new Exception("Subtract operator used on bool value");
        }

        // double dispatch IntegerValue
        public virtual Value Add(IntegerValue otherValue)
        {
            throw new Exception("Add operator used on non-integer value");
        }

        public virtual Value And(IntegerValue otherValue)
        {
            throw new Exception("And operator used on integer value");
        }
        public virtual Value Divide(IntegerValue otherValue)
        {
            throw new Exception("Divide operator used on non-integer value");
        }
        public virtual Value EqualTo(IntegerValue otherValue)
        {
            throw new Exception("Equals operator used on non-bool and non-integer value");
        }
        public virtual Value LargerThan(IntegerValue otherValue)
        {
            throw new Exception("Larger than operator used on non-integer value");
        }
        public virtual Value LargerThan_Equals(IntegerValue otherValue)
        {
            throw new Exception("Larger than or equals operator used on non-integer value");
        }
        public virtual Value Multiply(IntegerValue otherValue)
        {
            throw new Exception("Multiply operator used on bool value");
        }
        public virtual Value NotEquals(IntegerValue otherValue)
        {
            throw new Exception("Not equals operator used on non-bool and non-integer value");
        }
        public virtual Value Or(IntegerValue otherValue)
        {
            throw new Exception("Or operator used on integer value");
        }
        public virtual Value SmallerThan(IntegerValue otherValue)
        {
            throw new Exception("Smaller than operator used on non-integer value");
        }
        public virtual Value SmallerThan_Equals(IntegerValue otherValue)
        {
            throw new Exception("Smaller than or equals operator used on non-integer value");
        }
        public virtual Value Subtract(IntegerValue otherValue)
        {
            throw new Exception("Subtract operator used on non-integer value");
        }
    }
}
