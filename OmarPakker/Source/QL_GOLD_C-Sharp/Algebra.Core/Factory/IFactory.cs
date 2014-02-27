using Algebra.Core.Tree;

namespace Algebra.Core.Factory
{
	public interface IFactory<E, S, T>
        where E : IExprNode
        where S : IStmntNode
        where T : ITypeNode
	{

	}
}
