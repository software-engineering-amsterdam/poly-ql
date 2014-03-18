
namespace QSLib.Values
{
    public class UndefinedValue : Value
    {
        #region Getter
        public override object GetValue
        {
            get
            {
                return null;
            }
        }
        #endregion

        public override void CreateGUI(GUIBuilder guiBuilder)
        {
            guiBuilder.CreateStringOutput();
        }

        #region dispatch value
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
    }
}
