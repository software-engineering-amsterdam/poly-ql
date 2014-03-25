
namespace QL_Tests.Expr
{
    public class VarExpr : Algebra.Core.Expr.VarExpr, ITestExpr
    {
        public VarExpr(string name)
            : base(name)
        {

        }

        public override bool Equals(object obj)
        {
            if (!(obj is VarExpr))
            {
                return false;
            }

            return Name.Equals(((VarExpr)obj).Name);
        }

        public override int GetHashCode()
        {
            return Name.GetHashCode();
        }
    }
}
