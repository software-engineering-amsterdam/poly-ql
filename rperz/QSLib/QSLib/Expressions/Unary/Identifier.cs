using System;
using System.Collections.Generic;
using QSLib.Types;
using QSLib.Expressions.Literals;

namespace QSLib.Expressions.Unary
{
    public abstract class Identifier : Unary_Expression, IEquatable<Identifier>

    {
        private String _name;
        private bool _isInput = true;

        public Identifier(String name, int linenr)
            : base(null, linenr)
        {
            this._name = name;
            this._linenr = linenr;
        }

        public Identifier(String name, IExpression expr, int linenr)
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
        }

        public Identifier(String name, QSType type, IExpression expr, int linenr)
            : base(expr, linenr)
        {
            this._name = name;
            this._isInput = false;
            this._expr = expr;
            this._linenr = linenr;
            this._type = type;
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

        public override bool  CheckType(TypeChecker checker)
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

        public object GetValue()
        {
            return this._expr.GetValue();
        }


        /* tradeoff: I see two options, add these setters or maintain value outside this class,
         * which would destroy all benefits from databinding
         */

        public string SetStringValue
        {
            set
            {
                this._expr = new QSString(value, 1);
            }
        }

        public int SetNumberValue
        {
            set
            {
                this._expr = new QSNumber(value, 1);
            }
        }

        public bool SetBooleanValue
        {
            set
            {
                this._expr = new QSBoolean(value, 1);
            }
        }


        public void CreateGUI(GUIBuilder guiBuilder)
        {
            guiBuilder.CreateIO(this._type, this._isInput);
        }

    }
}
