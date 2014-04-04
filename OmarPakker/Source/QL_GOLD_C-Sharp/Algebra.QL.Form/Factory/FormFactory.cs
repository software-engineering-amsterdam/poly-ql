using Algebra.QL.Core.Factory;
using Algebra.QL.Eval.Factory;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Algebra.QL.Form.Stmnt;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Factory
{
    public class FormFactory : IFactory<IFormStmnt, IFormExpr, IFormType>
    {
        private readonly EvalFactory<IFormType> EvalFactory;

        public FormFactory()
            : this(new EvalFactory<IFormType>())
        {

        }

        protected FormFactory(EvalFactory<IFormType> evalFactory)
        {
            EvalFactory = evalFactory;
        }

        public IFormType StringType()
        {
            return new StringType();
        }

        public IFormType IntType()
        {
            return new IntType();
        }

        public IFormType RealType()
        {
            return new RealType();
        }

        public IFormType BoolType()
        {
            return new BoolType();
        }

        public IFormExpr String(string s)
        {
            return new StringLiteral(s);
        }

        public IFormExpr Int(int i)
        {
            return new IntLiteral(i);
        }

        public IFormExpr Real(double d)
        {
            return new RealLiteral(d);
        }

        public IFormExpr Bool(bool b)
        {
            return new BoolLiteral(b);
        }

        public IFormExpr Variable(string var)
        {
            return new VarExpr(var, EvalFactory.Variable(var));
        }

        public IFormExpr Or(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.Or(l, r));
        }

        public IFormExpr And(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.And(l, r));
        }

        public IFormExpr Eq(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.Eq(l, r));
        }

        public IFormExpr NotEq(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.NotEq(l, r));
        }

        public IFormExpr LessThen(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.LessThen(l, r));
        }

        public IFormExpr GreaterThen(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.GreaterThen(l, r));
        }

        public IFormExpr LessOrEqualTo(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.LessOrEqualTo(l, r));
        }

        public IFormExpr GreaterOrEqualTo(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.GreaterOrEqualTo(l, r));
        }

        public IFormExpr Add(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.Add(l, r));
        }

        public IFormExpr Subtract(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.Subtract(l, r));
        }

        public IFormExpr Multiply(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.Multiply(l, r));
        }

        public IFormExpr Divide(IFormExpr l, IFormExpr r)
        {
            return new BinaryExpr(l, r, EvalFactory.Divide(l, r));
        }

        public IFormExpr NegateBool(IFormExpr e)
        {
            return new NegateBoolExpr(e, EvalFactory.NegateBool(e));
        }

        public IFormExpr NegateNumeric(IFormExpr e)
        {
            return new NegateNumericExpr(e, EvalFactory.NegateNumeric(e));
        }

        public IFormExpr VarDecl(string var, IFormType t)
        {
            return new VarInitExpr(var, t, EvalFactory.VarAssign(var, t, t.DefaultValue));
        }

        public IFormExpr VarAssign(string var, IFormType t, IFormExpr e)
        {
            return new VarInitExpr(var, t, e, EvalFactory.VarAssign(var, t, e));
        }

        public IFormExpr IfElse(IFormExpr toEval, IFormExpr ifTrue, IFormExpr ifFalse)
        {
            return new IfElseExpr(toEval, ifTrue, ifFalse, EvalFactory.IfElse(toEval, ifTrue, ifFalse));
        }

        public IFormExpr ExpressionOrder(IFormExpr e)
        {
            return e; //We can skip this
        }

        public IFormStmnt Statements(IFormStmnt l, IFormStmnt r)
        {
            return new StatementsStmnt(l, r);
        }

        public IFormStmnt Form(string var, IFormStmnt s)
        {
            return new FormStmnt(var, s);
        }

        public IFormStmnt Question(string s, IFormExpr e)
        {
            return new QuestionStmnt(s, e);
        }

        public IFormStmnt Label(string s, IFormExpr e)
        {
            return new LabelStmnt(s, e);
        }

        public IFormStmnt If(IFormExpr toEval, IFormStmnt ifTrue)
        {
            return new IfStmnt(toEval, ifTrue);
        }

        public IFormStmnt IfElse(IFormExpr toEval, IFormStmnt ifTrue, IFormStmnt ifFalse)
        {
            return new IfElseStmnt(toEval, ifTrue, ifFalse);
        }

        public IFormStmnt Block(IFormStmnt s)
        {
            return s; //We can skip this
        }
    }
}
