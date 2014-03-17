using QSLib.Types;
using QSLib.Expressions.Values;
using System.ComponentModel;
namespace QSLib.Expressions
{
    public abstract class QSExpression : INotifyPropertyChanged 
    {
        protected QSType _type;
        protected int _linenr;
        protected Value _value;

        public abstract bool CheckType(TypeChecker checker);

        public abstract QSType Type
        {
            get;
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        // methods to update and get the value and notify on value change
        public abstract Value Evaluate();

        public Value GetValue
        {
            get { return this._value; }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        protected virtual void OnPropertyChanged(string name)
        {
            var handler = this.PropertyChanged;
            if (handler != null)
            {
                handler(this, new PropertyChangedEventArgs(name));
            }
        }
    }
}
