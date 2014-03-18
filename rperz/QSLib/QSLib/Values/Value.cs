using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Values
{
    public abstract class Value
    {
        public abstract object GetValue { get; }
        public abstract void CreateGUI(GUIBuilder guiBuilder);

        public abstract Value Add(Value otherValue);

        public abstract Value And(Value otherValue);
        public abstract Value Divide(Value otherValue);
        public abstract Value EqualTo(Value otherValue);
        public abstract Value LargerThan(Value otherValue);
        public abstract Value LargerThan_Equals(Value otherValue);
        public abstract Value Multiply(Value otherValue);
        public abstract Value NotEquals(Value otherValue);
        public abstract Value Or(Value otherValue);
        public abstract Value SmallerThan(Value otherValue);
        public abstract Value SmallerThan_Equals(Value otherValue);
        public abstract Value Subtract(Value otherValue);

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

        // double dispatch Undefined Value
        public virtual Value Add(UndefinedValue otherValue)
        {
            throw new Exception("Add operator used on undefined value");
        }

        public virtual Value And(UndefinedValue otherValue)
        {
            throw new Exception("And operator used on undefined value");
        }
        public virtual Value Divide(UndefinedValue otherValue)
        {
            throw new Exception("Divide operator used on undefined value");
        }
        public virtual Value EqualTo(UndefinedValue otherValue)
        {
            throw new Exception("Equals operator used on undefined value");
        }
        public virtual Value LargerThan(UndefinedValue otherValue)
        {
            throw new Exception("Larger than operator used on undefined value");
        }
        public virtual Value LargerThan_Equals(UndefinedValue otherValue)
        {
            throw new Exception("Larger than or equals operator used on undefined value");
        }
        public virtual Value Multiply(UndefinedValue otherValue)
        {
            throw new Exception("Multiply operator used on undefined value");
        }
        public virtual Value NotEquals(UndefinedValue otherValue)
        {
            throw new Exception("Not equals operator used on undefined value");
        }
        public virtual Value Or(UndefinedValue otherValue)
        {
            throw new Exception("Or operator used on undefined value");
        }
        public virtual Value SmallerThan(UndefinedValue otherValue)
        {
            throw new Exception("Smaller than operator used on undefined value");
        }
        public virtual Value SmallerThan_Equals(UndefinedValue otherValue)
        {
            throw new Exception("Smaller than or equals operator used on undefined value");
        }
        public virtual Value Subtract(UndefinedValue otherValue)
        {
            throw new Exception("Subtract operator used on undefined value");
        }

    }
}
