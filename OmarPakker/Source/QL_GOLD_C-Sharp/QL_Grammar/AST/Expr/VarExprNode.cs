using QL_Grammar.AST.Types;

namespace QL_Grammar.AST.Expr
{
    public class VarExprNode<E> : IExprNode
        where E : IExprNode
    {
        public string Name { get; private set; }
        public IType Type { get; private set; }
        public E Value { get; private set; }

        public VarExprNode(string name, IType type, E value)
		{
            Name = name;
            Type = type;
            Value = value;
		}
    }
}
