using QL_Grammar.AST.Stmnt;

namespace QL_Grammar.QL.Stmnt
{
	public class FormStmnt : FormStmntNode<IStmntNode>, IStmntNode
    {
		public FormStmnt(string name, IStmntNode body)
            : base(name, body)
        {

        }
    }
}
