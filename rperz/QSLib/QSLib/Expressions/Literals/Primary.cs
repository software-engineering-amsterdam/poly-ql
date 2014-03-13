using QSLib.Types;

namespace QSLib.Expressions.Literals
{
    public abstract class Primary : IExpression
    {
        protected int _linenr;
        protected QSType _type;

        public virtual bool CheckType(TypeChecker checker)
        {
            return true;
        }

        public abstract object GetValue();

        public QSType Type
        {
            get 
            {
                return this._type;
            }
        }

        public override bool Equals(object obj)
        {
            var temp = obj as Primary;
            return temp != null && this.Type.IsCompatible(temp.Type);
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }
    }
}
