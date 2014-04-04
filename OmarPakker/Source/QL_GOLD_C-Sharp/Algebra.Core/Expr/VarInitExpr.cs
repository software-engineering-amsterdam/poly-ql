
namespace Algebra.Core.Expr
{
    public class VarInitExpr<E, T>
    {
        public string Name { get; private set; }
        public T Type { get; private set; }
        public E Value { get; private set; }

        public VarInitExpr(string name, T type, E value)
        {
            Name = name;
            Type = type;
            Value = value;
        }
    }
}
