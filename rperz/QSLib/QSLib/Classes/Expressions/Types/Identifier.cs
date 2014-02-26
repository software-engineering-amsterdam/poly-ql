using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions;
using QSLib.Errors;
namespace QSLib.Expressions.Types
{
    public class Identifier : IExpression
    {
        private static Dictionary<String, Type> identifiers = new Dictionary<String, Type>();
        private String _name;
        private IExpression _value;
        private Type _type;
        private int _linenr;
        private bool _isdeclaration = false;


        public Identifier(String name, int linenr)
        {
            this._name = name;
            this._linenr = linenr;

            identifiers.TryGetValue(this._name, out this._type);
        }

        public Identifier(String name, IExpression val, int linenr)
        {
            this._name = name;
            this._value = val;
            this._linenr = linenr;

            identifiers.TryGetValue(this._name, out this._type);
        }

        public void Declare()
        {
            this._isdeclaration = true;
        }

        public Type SetType
        {
            set
            {
                this._type = value;
            }
        }

        public Type Type
        {
            get
            {
                identifiers.TryGetValue(this._name, out this._type);

                if (this._type != null)
                    return this._type;
                else
                {
                    // if this is a undeclared variable, then report it
                    TypeChecker.ReportUndeclared(this._name, this._linenr);
                    return new NullObject().GetType();
                }

            }
        }

        public bool CheckType()
        {
            // if this is a declaration, check if it's a duplicate
            if (this._isdeclaration)
            {
                if (identifiers.ContainsKey(this._name))
                {
                    TypeChecker.ReportDuplicate(this._name, this._linenr);
                    return false;
                }
                else
                    identifiers.Add(this._name, this._type);
            }

            // check type of value and of identifier
            if (this._value != null)
                return this._value.CheckType() && (this._value.Type.Equals(this.Type));
            else if (this._type != null)
                return true;
            else if (identifiers.ContainsKey(this._name))
                return true;
            else
            {
                TypeChecker.ReportUndeclared(this._name, this._linenr);
                return false;
            }
        }

        public override string ToString()
        {
            if(this._value == null)
                return this._name.ToString();
            else
                return this._name.ToString() + " = " + this._value.ToString();
        }

        public static void ClearIdentifiers()
        {
            identifiers.Clear();
        }

        public override bool Equals(object obj)
        {
            var temp = obj as Identifier;
            bool retVal = true;
            if (temp == null)
                return false;

            // test if both values are set and if so equal
            if (this._name != null && temp._name != null)
                retVal &= this._name.Equals(temp._name);
            else if(this._name != null || temp._name != null)
                retVal &= false;

            // test if both values are set and if so equal
            if (this._value != null && temp._value != null)
                retVal &= this._value.Equals(temp._value);
            else if (this._value != null && temp._value != null)
                retVal &= false;

            // test if both types are set and if so equal
            if (this.Type != null && temp.Type != null)
                retVal &= this.Type.Equals(temp.Type);
            else if (this._type != null || temp._type != null)
                retVal = false;

            // test if both are a declaration or both are not
            if (this._isdeclaration != temp._isdeclaration)
                retVal = false;

            return retVal ;
        }
    }
}
