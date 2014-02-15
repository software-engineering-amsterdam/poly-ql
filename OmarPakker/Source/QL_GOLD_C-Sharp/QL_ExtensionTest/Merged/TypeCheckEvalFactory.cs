using QL_ExtensionTest.QLAlgebraExtensions.Factory;
using QL_ExtensionTest.QLEval.Expr;
using QL_ExtensionTest.QLEval.Factory;
using QL_ExtensionTest.QLEval.Stmnt;
using QL_ExtensionTest.QLTypeCheckExtensions.Factory;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace QL_ExtensionTest.Merged
{
    public class TypeCheckEvalFactory : QLExtensionsFactoryCombination<ITypeCheckExpr, ITypeCheckStmnt, IEvalExpr, IEvalStmnt, QLTypeCheckExtensionsFactory, QLEvalFactory>
    {
        public TypeCheckEvalFactory()
            : base(new QLTypeCheckExtensionsFactory(), new QLEvalFactory())
        {

        }
    }
}
