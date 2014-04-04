using Algebra.QL.Extensions.Factory;
using Algebra.QL.Extensions.Print.Factory;
using Algebra.QL.Extensions.TypeCheck.Factory;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Stmnt;
using Algebra.QL.Print.Type;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;

namespace WPFParser.MergedFactory
{
    public class TypeCheckPrintFactory
        : FactoryCombination<ITypeCheckStmnt, ITypeCheckExpr, ITypeCheckType,
          IPrintStmnt, IPrintExpr, IPrintType, TypeCheckFactory, PrintFactory>
    {
        public TypeCheckPrintFactory()
            : base(new TypeCheckFactory(), new PrintFactory())
        {

        }
    }
}
