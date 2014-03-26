using Algebra.Core.Collections;
using Algebra.QL.Extensions.Factory;
using Algebra.QL.Extensions.Form.Factory;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Stmnt;
using Algebra.QL.Form.Type;
using Algebra.QL.Print.Expr;
using Algebra.QL.Print.Stmnt;
using Algebra.QL.Print.Type;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;

namespace WPFParser.MergedFactory
{
    public class TypeCheckPrintFormFactory
        : FactoryCombination<IPair<ITypeCheckStmnt, IPrintStmnt>, IPair<ITypeCheckExpr, IPrintExpr>,
          IPair<ITypeCheckType, IPrintType>, IFormStmnt, IFormExpr, IFormType, TypeCheckPrintFactory, FormFactory>
    {
        public TypeCheckPrintFormFactory()
            : base(new TypeCheckPrintFactory(), new FormFactory())
        {

        }
    }
}
