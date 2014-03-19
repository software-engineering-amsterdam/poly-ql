using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Types;
using QSLib.Values;
namespace QSLib.AST.Expressions.Unary.Identifiers
{
    public class InputIdentifier : Identifier
    {
        #region Constructors

        public InputIdentifier(String name, QSType type, int lineNr)
            : base(null, lineNr)
        {
            this._name = name;
            this._lineNr = lineNr;
            this._type = type;
            this._value = this._type.GetUndefinedValue(true);
        }
        #endregion


        #region Value setters
        public string SetStringValue
        {
            set
            {
                this._value = new StringValue(value, true);
            }
        }

        public bool SetBooleanValue
        {
            set
            {
                this._value = new BooleanValue(value, true);
            }
        }

        public int SetIntegerValue
        {
            set
            {
                this._value = new IntegerValue(value, true);
            }
        }
        #endregion

        public override void CreateGUI(GUIBuilder guiBuilder)
        {
            this._type.CreateGUI(guiBuilder);
            guiBuilder.SetToInput(this);
        }
    }
}
