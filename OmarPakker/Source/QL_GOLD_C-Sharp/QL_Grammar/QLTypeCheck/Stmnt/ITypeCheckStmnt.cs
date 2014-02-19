using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Stmnt
{
	public interface ITypeCheckStmnt : ITypeCheck
	{
		void TypeCheck(TypeCheckData data);
	}
}
