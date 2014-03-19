using System;
using QSLib.Types;
using QSLib.Values;
using QSLib.Visitors;
namespace QSLib.AST.Expressions.Unary.Identifiers
{
    public class Identifier : Unary_Expression

    {
        protected Identifier _parent;
        protected String _name;

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
            this._internal = internalExpression;
            this._lineNr = lineNr;
            this._value = this.Evaluate();
        }

        public Identifier(String name, QSType type, QSExpression internalExpression, int lineNr)
            : base(internalExpression, lineNr)
        {
            this._name = name;
            this._internal = internalExpression;
            this._lineNr = lineNr;
            this._type = type;
            this._value = this.Type.GetUndefinedValue(false);
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
        public override void Accept(IVisitor checker)
        {
            checker.Visit(this);
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
            return temp != null && this._name.Equals(temp._name);
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


        public virtual void CreateGUI(GUIBuilder guiBuilder)
        {           
            // this is neither a input nor an output, so no GUI is going to be build here.
        }
    }
}
