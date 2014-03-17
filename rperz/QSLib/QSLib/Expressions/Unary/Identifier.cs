using System;
using System.Collections.Generic;
using QSLib.Types;
using QSLib.Expressions.Literals;
using System.ComponentModel;
using QSLib.Expressions.Values;

namespace QSLib.Expressions.Unary
{
    public class Identifier : Unary_Expression, IEquatable<Identifier>

    {
        private String _name;
        private bool _isInput = true;

        public Identifier(String name, int linenr)
            : base(null, linenr)
        {
            this._name = name;
            this._linenr = linenr;
        }

        public Identifier(String name, QSExpression expr, int linenr)
            : base(expr, linenr)
        {
            this._name = name;
            this._isInput = false;
            this._expr = expr;
            this._linenr = linenr;
        }

        public Identifier(String name, QSType type, int linenr)
            : base(null, linenr)
        {
            this._name = name;
            this._linenr = linenr;
            this._type = type;
            this._value = this._type.GetUndefinedValue();
        }

        public Identifier(String name, QSType type, QSExpression expr, int linenr)
            : base(expr, linenr)
        {
            this._name = name;
            this._isInput = false;
            this._expr = expr;
            this._linenr = linenr;
            this._type = type;
        }

        public string SetStringValue
        {
            set
            {
                this._value = new StringValue(value);
            }
        }

        public bool SetBooleanValue
        {
            set
            {
                this._value = new BooleanValue(value);
            }
        }

        public int SetIntegerValue
        {
            set
            {
                this._value = new IntegerValue(value);
            }
        }

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

        public override bool CheckType(TypeChecker checker)
        {
            bool retVal = true;
            if (this._type == null)
            {
                this._type = checker.TryGetType(this, this._linenr);
                this._expr = checker.TryGetValue(this);
            }
            else
                retVal &= checker.TryDeclare(this, this._linenr);

            if(this._type == null)
                retVal &= false;

            retVal &= base.CheckType(checker);
            return retVal;
        }

        public override string ToString()
        {
            if (this._expr == null)
                return this._name.ToString();
            else
                return this._name.ToString() + " = " + this._expr.ToString();
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

        bool IEquatable<Identifier>.Equals(Identifier other)
        {
            return this._name.Equals(other._name);
        }

        public override Value Evaluate()
        {
            if (this._expr == null)
                return this._value;
            this._value = this._expr.Evaluate();
            this.OnPropertyChanged("GetValue");
            return this._value;
        }


        public void CreateGUI(GUIBuilder guiBuilder)
        {
            this._value.CreateGUI(guiBuilder);
            if (this._isInput)
                guiBuilder.SetToInput(this);
            else
                guiBuilder.SetToOutput(this);

        }

    }
}
