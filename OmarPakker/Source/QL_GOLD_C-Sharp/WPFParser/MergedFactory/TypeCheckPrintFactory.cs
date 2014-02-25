using Algebra.QL.Extensions.Factory;
using Algebra.QL.Extensions.TypeCheck.Factory;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Factory;
using Algebra.QL.Print.Stmnt;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Stmnt;

namespace WPFParser.MergedFactory
{
    public class TypeCheckPrintFactory
		: QLExtensionsFactoryCombination<ITypeCheckExpr, ITypeCheckStmnt, IPrintExpr, IPrintStmnt, QLTypeCheckExtensionsFactory, QLPrintFactory>
    {
        public TypeCheckPrintFactory()
            : base(new QLTypeCheckExtensionsFactory(), new QLPrintFactory())
        {

        }
    }
}
