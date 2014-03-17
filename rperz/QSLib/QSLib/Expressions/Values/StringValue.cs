using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QSLib.Expressions.Values
{
    public class StringValue : Value
    {
        protected string _value;
        public StringValue(string value)
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
            guiBuilder.CreateStringIO();
        }
    }
}
