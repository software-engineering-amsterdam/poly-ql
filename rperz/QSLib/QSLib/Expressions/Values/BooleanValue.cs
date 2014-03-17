using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Values
{
    public class BooleanValue : Value
    {
        protected bool _value;
        public BooleanValue(bool value)
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
            guiBuilder.CreateBooleanIO();
        }

        public override Value Not()
        {
            return new BooleanValue(!this._value);
        }

        // double dispatch BoolValue
        public override Value And(BooleanValue otherValue)
        {
            return otherValue.And(this);
        }
        public override Value EqualTo(BooleanValue otherValue)
        {
            return otherValue.EqualTo(this);
        }
        public override Value NotEquals(BooleanValue otherValue)
        {
            return otherValue.NotEquals(this);
        }
        public override Value Or(BooleanValue otherValue)
        {
            return otherValue.Or(this);
        }
    }
}
