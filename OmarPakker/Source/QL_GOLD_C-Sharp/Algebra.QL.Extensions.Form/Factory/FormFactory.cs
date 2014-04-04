using System;
using Algebra.QL.Extensions.Eval.Factory;
using Algebra.QL.Extensions.Factory;
using Algebra.QL.Extensions.Form.Expr;
using Algebra.QL.Extensions.Form.Expr.Literals;
using Algebra.QL.Extensions.Form.Stmnt;
using Algebra.QL.Extensions.Form.Type;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Stmnt;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Extensions.Form.Factory
{
    public class FormFactory : QL.Form.Factory.FormFactory, IFactory<IFormStmnt, IFormExpr, IFormType>
    {
        private readonly EvalFactory<IFormType> EvalFactory;

        public FormFactory()
            : this(new EvalFactory<IFormType>())
        {

        }

        protected FormFactory(EvalFactory<IFormType> evalFactory)
            : base(evalFactory)
        {
            EvalFactory = evalFactory;
        }

        public IFormType DateType()
        {
            return new DateType();
        }

        public IFormExpr Date(DateTime date)
        {
            return new DateLiteral(date);
        }

        public IFormExpr Modulo(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.Modulo(l, r));
        }

        public IFormExpr Power(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.Power(l, r));
        }

        public IFormStmnt Forms(IFormStmnt l, IFormStmnt r)
        {
            return new FormsStmnt(l, r);
        }

        public IFormStmnt Goto()
        {
            return new GotoStmnt();
        }

        public IFormStmnt Repeat(IFormExpr e, IFormStmnt s)
        {
            return new RepeatStmnt(e, s);
        }

        public IFormExpr Sum(string s)
        {
            return new SumExpr(s);
        }

        public IFormExpr Average(string s)
        {
            return new AvgExpr(s);
        }
    }
}
