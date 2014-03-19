
namespace QSLib.Values
{
    public class BooleanValue : Value
    {
        protected bool _value;
        private bool _isInput;

        #region Constructors
        public BooleanValue(bool value, bool isInput = false)
        {
            this._isInput = isInput;
            this._value = value;
        }
        #endregion

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
                guiBuilder.CreateBooleanInput();
            else
                guiBuilder.CreateBooleanOutput();
        }

        #region dispatch
        public override Value Not()
        {
            return new BooleanValue(!this._value);
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
        #endregion

        #region double dispatch BoolValue
        public override Value And(BooleanValue otherValue)
        {
            return new BooleanValue(otherValue._value && this._value);
        }
        public override Value EqualTo(BooleanValue otherValue)
        {
            return new BooleanValue(otherValue._value == this._value);
        }
        public override Value NotEquals(BooleanValue otherValue)
        {
            return new BooleanValue(otherValue._value != this._value);
        }
        public override Value Or(BooleanValue otherValue)
        {
            return new BooleanValue(otherValue._value || this._value);
        }
        #endregion
    }
}
