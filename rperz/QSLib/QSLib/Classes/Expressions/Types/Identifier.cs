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
        private String _name;
        private IExpression _value;
        private Type _type;

        public Identifier(String name)
        {
            this._name = name;
        }

        public Identifier(String name, IExpression val)
        {
            this._name = name;
            this._value = val;
        }

        public Type SetType
        {
            set
            {
                this._type = value;
            }
        }

        public Type CheckType()
        {
            if (this._value != null)
                return this._value.CheckType();
            else
                throw new TypeException("Type nog specified on identifier " + this._name);
        }
        public override string ToString()
        {
            if(this._value != null)
                return this._name.ToString();
            else
                return this._name.ToString() + " = " + this._value.ToString();
        }
    }
}
