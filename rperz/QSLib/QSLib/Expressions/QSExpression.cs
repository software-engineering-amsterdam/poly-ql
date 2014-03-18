using QSLib.Types;
using QSLib.Values;
using System.ComponentModel;
namespace QSLib.Expressions
{
    public abstract class QSExpression : INotifyPropertyChanged 
    {
        protected QSType _type;
        protected int _lineNr;
        protected Value _value = new UndefinedValue();
        protected string _operator;

        public abstract void Check(TypeChecker checker);

        // methods to update and get the value and notify on value change
        public abstract Value Evaluate();

        #region Getters
        public abstract QSType Type
        {
            get;
        }

        public object GetValue
        {
            get { return this._value.GetValue; }
        }

        public int Line
        {
            get
            {
                return this._lineNr;
            }
        }

        public string Operator
        {
            get
            {
                return this._operator;
            }
        }
        #endregion

        #region Eventhandlers
        public event PropertyChangedEventHandler PropertyChanged;

        protected virtual void OnPropertyChanged(string name)
        {
            var handler = this.PropertyChanged;
            if (handler != null)
            {
                handler(this, new PropertyChangedEventArgs(name));
            }
        }
        #endregion

        #region Object overrides
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
        #endregion
    }
}
