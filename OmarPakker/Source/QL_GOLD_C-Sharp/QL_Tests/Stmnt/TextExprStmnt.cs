using Algebra.QL.Core.Stmnt;
using QL_Tests.Expr;

namespace QL_Tests.Stmnt
{
    public class TextExprStmnt : TextExprStmnt<ITestExpr>, ITestStmnt
    {
        public TextExprStmnt(string text, ITestExpr expr)
            : base(text, expr)
        {

        }

        public override bool Equals(object obj)
        {
            if (!(obj is TextExprStmnt))
            {
                return false;
            }

            TextExprStmnt other = (TextExprStmnt)obj;
            return Text.Equals(other.Text) && Expression.Equals(other.Expression);
        }

        public override int GetHashCode()
        {
            return Text.GetHashCode() ^ Expression.GetHashCode();
        }
    }
}
