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
        private static List<String> identifiers = new List<string>();
        private String _name;
        private IExpression _value;
        private Type _type;
        private int _linenr;

        public Identifier(String name, int linenr)
        {
            this._name = name;
            this._linenr = linenr;
        }

        public Identifier(String name, IExpression val, int linenr)
        {
            this._name = name;
            this._value = val;
            this._linenr = linenr;
        }

        public void Declare()
        {
            if (identifiers.Contains(this._name))
                TypeChecker.ReportDuplicate(this._name, this._linenr);
            else
                identifiers.Add(this._name);
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
                return this._type;
            }
        }

        public bool CheckType()
        {
            if (this._value != null)
                return this._value.CheckType();
            else
                throw new TypeException("Type nog specified on identifier " + this._name);
        }

        public override string ToString()
        {
            if(this._value == null)
                return this._name.ToString();
            else
                return this._name.ToString() + " = " + this._value.ToString();
        }
    }
}
