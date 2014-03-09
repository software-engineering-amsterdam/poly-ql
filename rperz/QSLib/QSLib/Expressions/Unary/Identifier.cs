using System;
using System.Collections.Generic;
using QSLib.Types;

namespace QSLib.Expressions.Unary
{
    public class Identifier : Unary_Expression, IEquatable<Identifier>

    {
        private String _name;

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
                this._type = checker.TryGetType(this, this._linenr);
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
    }
}
