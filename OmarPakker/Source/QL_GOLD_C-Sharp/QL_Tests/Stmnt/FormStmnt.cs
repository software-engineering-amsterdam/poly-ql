using Algebra.QL.Core.Stmnt;

namespace QL_Tests.Stmnt
{
    public class FormStmnt : FormStmnt<ITestStmnt>, ITestStmnt
    {
        public FormStmnt(string name, ITestStmnt body)
            : base(name, body)
        {

        }

        public override bool Equals(object obj)
        {
            if (!(obj is FormStmnt))
            {
                return false;
            }

            FormStmnt other = (FormStmnt)obj;
            return Name.Equals(other.Name) && Body.Equals(other.Body);
        }

        public override int GetHashCode()
        {
            return Name.GetHashCode() ^ Body.GetHashCode();
        }
    }
}
