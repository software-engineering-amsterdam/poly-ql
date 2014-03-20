using QSLib.Types;
using QSLib.Values;
using QSLib.Visitors;
namespace QSLib.AST.Expressions.Literals
{
    public abstract class Primary : QSExpression
    {
        public override void Accept(IVisitor checker)
        {
            checker.Visit(this);
        }

        public override QSType Type
        {
            get 
            {
                return this._type;
            }
        }

        public override Value Evaluate()
        {
            this.OnPropertyChanged("GetValue");
            return this._value;
        }


        #region Object overrides
        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            var temp = obj as Primary;
            return temp != null && this.Type.IsCompatible(temp.Type);
        }
        #endregion

    }
}
