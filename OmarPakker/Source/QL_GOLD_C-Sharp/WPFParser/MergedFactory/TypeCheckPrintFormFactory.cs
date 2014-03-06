using System;
using Algebra.QL.Extensions.Factory;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Factory;
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
		: ExtFactoryCombination<Tuple<ITypeCheckExpr, IPrintExpr>, Tuple<ITypeCheckStmnt, IPrintStmnt>,
          Tuple<ITypeCheckType, IPrintType>, IFormExpr, IFormStmnt, IFormType, TypeCheckPrintFactory, FormFactory>
    {
        public TypeCheckPrintFormFactory()
            : base(new TypeCheckPrintFactory(), new FormFactory())
        {

        }
    }
}
