using System;
using QSLib.Types;
using QSLib.Values;

namespace QSLib.Expressions.Unary
{
    public class Identifier : Unary_Expression

    {
        private Identifier _parent;
        private String _name;
        private bool _isInput = true;

        #region Constructors
        public Identifier(String name, int lineNr)
            : base(null, lineNr)
        {
            this._name = name;
            this._lineNr = lineNr;
        }

        public Identifier(String name, QSExpression internalExpression, int lineNr)
            : base(internalExpression, lineNr)
        {
            this._name = name;
            this._isInput = false;
            this._internal = internalExpression;
            this._lineNr = lineNr;
            this._value = this.Evaluate();
        }

        public Identifier(String name, QSType type, int lineNr)
            : base(null, lineNr)
        {
            this._name = name;
            this._lineNr = lineNr;
            this._type = type;
            this._value = this._type.GetUndefinedValue(true);
        }

        public Identifier(String name, QSType type, QSExpression internalExpression, int lineNr)
            : base(internalExpression, lineNr)
        {
            this._name = name;
            this._isInput = false;
            this._internal = internalExpression;
            this._lineNr = lineNr;
            this._type = type;
            this._value = this.Type.GetUndefinedValue(false);
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

        #region getters/setters
        public string Name
        {
            get
            {
                return this._name;
            }
        }

        public override QSType Type
        {
            get
            {
                if (this._type != null)
                    return this._type;
                else
                    return null;
            }
        }

        public Identifier Parent
        {
            get
            {
                return this._parent;
            }
            set
            {
                this._parent = value;
                this._type = this._parent.Type;
            }
        }
#endregion

        #region Type checker
        public override void Check(TypeChecker checker)
        {
            checker.Check(this);
        }

        internal override void CheckInternal(TypeChecker typeChecker)
        {
            if(this._internal != null)
                this._internal.Check(typeChecker);
        }
        #endregion

        #region Object overrides
        public override string ToString()
        {
            if (this._internal  == null)
                return this._name.ToString();
            else
                return this._name.ToString() + " = " + this._internal.ToString();
        }

        public override bool Equals(object obj)
        {
            var temp = obj as Identifier;
            return temp != null && this._name.Equals(temp._name) && base.Equals(obj);
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
        #endregion

        public override Value Evaluate()
        {
            if (this._parent != null)
                this._value = this._parent._value;
            else if (this._internal != null)
                this._value = this._internal.Evaluate();
            
            this.OnPropertyChanged("GetValue");
            return this._value;
        }


        public void CreateGUI(GUIBuilder guiBuilder)
        {           
            if (this._isInput)
            {
                this._type.CreateGUI(guiBuilder);
                guiBuilder.SetToInput(this);
            }
            else
            {
                this._value.CreateGUI(guiBuilder);
                guiBuilder.SetToOutput(this);
            }
        }
    }
}
