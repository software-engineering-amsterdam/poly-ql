
namespace QL_Tests.Expr
{
    public class AvgExpr : ITestExpr
    {
        private readonly string varName;

        public AvgExpr(string s)
        {
            varName = s;
        }

        public override bool Equals(object obj)
        {
            if (!(obj is AvgExpr))
            {
                return false;
            }

            return varName.Equals(((AvgExpr)obj).varName);
        }

        public override int GetHashCode()
        {
            return varName.GetHashCode();
        }
    }
}
