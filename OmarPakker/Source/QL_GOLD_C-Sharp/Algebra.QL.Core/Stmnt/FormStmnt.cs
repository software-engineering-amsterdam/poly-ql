
namespace Algebra.QL.Core.Stmnt
{
    public abstract class FormStmnt<S>
    {
        public string Name { get; private set; }
        public S Body { get; private set; }

        public FormStmnt(string name, S body)
        {
            Name = name;
            Body = body;
        }
    }
}
