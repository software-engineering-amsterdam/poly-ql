
namespace QL_Grammar.AST.Stmnt
{
    public class FormStmntNode<S> : IStmntNode
        where S : IStmntNode
    {
        public string Name { get; private set; }
        public S Body { get; private set; }

        public FormStmntNode(string name, S body)
        {
            Name = name;
            Body = body;
        }
    }
}
