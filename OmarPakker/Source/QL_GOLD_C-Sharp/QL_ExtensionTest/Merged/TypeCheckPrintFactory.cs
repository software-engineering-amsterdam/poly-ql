using QL_ExtensionTest.QLAlgebraExtensions.Factory;
using QL_ExtensionTest.QLPrint.Expr;
using QL_ExtensionTest.QLPrint.Factory;
using QL_ExtensionTest.QLPrint.Stmnt;
using QL_ExtensionTest.QLTypeCheckExtensions.Factory;
using QL_Grammar.QLTypeCheck.Expr;
using QL_Grammar.QLTypeCheck.Stmnt;

namespace QL_ExtensionTest.Merged
{
    public class TypeCheckPrintFactory
		: QLExtensionsFactoryCombination<ITypeCheckExpr, ITypeCheckStmnt, IPrintExpr, IPrintStmnt, QLTypeCheckExtensionsFactory, QLEvalFactory>
    {
        public TypeCheckPrintFactory()
            : base(new QLTypeCheckExtensionsFactory(), new QLEvalFactory())
        {

        }
    }
}
