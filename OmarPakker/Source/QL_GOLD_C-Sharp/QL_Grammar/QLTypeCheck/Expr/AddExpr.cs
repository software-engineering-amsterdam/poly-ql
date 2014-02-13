using System;
using QL_Grammar.Algebra.Type;
using QL_Grammar.QLAlgebra.Expr;
using QL_Grammar.QLAlgebra.Types;
using QL_Grammar.QLTypeCheck.Helpers;

namespace QL_Grammar.QLTypeCheck.Expr
{
	public class AddExpr : DoubleExpr<ITypeCheckExpr>, ITypeCheckExpr
    {
        //public event OnTypeCheckErrorEventHandler OnTypeCheckError;

		public AddExpr(ITypeCheckExpr l, ITypeCheckExpr r)
            : base(l, r)
        {

        }

        //public Tuple<IType, bool> TypeCheck()
        //{
        //    Expr1.OnTypeCheckError += OnTypeCheckError;
        //    Expr2.OnTypeCheckError += OnTypeCheckError;

        //    Tuple<IType, bool> a = Expr1.TypeCheck();
        //    Tuple<IType, bool> b = Expr2.TypeCheck();

        //    if (!(a.Item1 is NumericType) || !a.Item1.CompatibleWith(b.Item1))
        //    {
        //        AddError(String.Format("Addition not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
        //            a.ToString(), b.ToString()), true, SourcePosition);

        //        return NumericType.Instance;
        //    }
        //    var tmp = this.CreateTypeCheckError(String.Format("Addition not possible. Incompatible types: '{0}', '{1}'. Only numeric types are supported.",
        //        a.ToString(), b.ToString()), true);
        //    OnTypeCheckError(tmp.Item1, tmp.Item2);

        //    return (a is RealType || b is RealType) ? (IType)RealType.Instance : (IType)IntType.Instance;
        //}
    }
}
