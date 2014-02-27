using Algebra.Core.Expr;
using QL_Tests.Type;

namespace QL_Tests.Expr
{
    public class VarInitExpr : VarInitExpr<ITestExpr, ITestType>, ITestExpr
    {
        public VarInitExpr(string name, ITestType type, ITestExpr value)
            : base(name, type, value)
		{

		}

        public override bool Equals(object obj)
        {
            if (!(obj is VarInitExpr))
            {
                return false;
            }

            VarInitExpr other = (VarInitExpr)obj;
            return Name.Equals(other.Name) && Type.Equals(other.Type) && Value.Equals(other.Value);
        }

        public override int GetHashCode()
        {
            return Name.GetHashCode() ^ Type.GetHashCode() ^ Value.GetHashCode();
        }
    }
}
