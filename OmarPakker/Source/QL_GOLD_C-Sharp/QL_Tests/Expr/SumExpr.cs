
namespace QL_Tests.Expr
{
    public class SumExpr : ITestExpr
    {
        private readonly string varName;

        public SumExpr(string s)
        {
            varName = s;
        }

        public override bool Equals(object obj)
        {
            if (!(obj is SumExpr))
            {
                return false;
            }

            return varName.Equals(((SumExpr)obj).varName);
        }

        public override int GetHashCode()
        {
            return varName.GetHashCode();
        }
    }
}
