using Algebra.QL.Core.Factory;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Expr.Literals;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;

namespace Algebra.QL.TypeCheck.Factory
{
    public class TypeCheckFactory : IStmntFactory<ITypeCheckStmnt, ITypeCheckExpr, ITypeCheckType>
    {
        public TypeCheckFactory()
        {

        }

        public ITypeCheckType StringType()
        {
            return new StringType();
        }

        public ITypeCheckType IntType()
        {
            return new IntType();
        }

        public ITypeCheckType RealType()
        {
            return new RealType();
        }

        public ITypeCheckType BoolType()
        {
            return new BoolType();
        }

        public ITypeCheckExpr String(string s)
        {
            return new StringLiteral(s);
        }

        public ITypeCheckExpr Int(int i)
        {
            return new IntLiteral(i);
        }

        public ITypeCheckExpr Real(double d)
        {
            return new RealLiteral(d);
        }

        public ITypeCheckExpr Bool(bool b)
        {
            return new BoolLiteral(b);
        }

        public ITypeCheckExpr Variable(string var)
        {
            return new VarExpr(var);
        }

        public ITypeCheckExpr Or(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new OrExpr(l, r);
        }

        public ITypeCheckExpr And(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new AndExpr(l, r);
        }

        public ITypeCheckExpr Eq(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new EqualsExpr(l, r);
        }

        public ITypeCheckExpr NotEq(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new NotEqualExpr(l, r);
        }

        public ITypeCheckExpr LessThen(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new LessThenExpr(l, r);
        }

        public ITypeCheckExpr GreaterThen(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new GreaterThenExpr(l, r);
        }

        public ITypeCheckExpr LessOrEqualTo(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new LessOrEqualToExpr(l, r);
        }

        public ITypeCheckExpr GreaterOrEqualTo(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new GreaterOrEqualToExpr(l, r);
        }

        public ITypeCheckExpr Add(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new AddExpr(l, r);
        }

        public ITypeCheckExpr Subtract(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new SubtractExpr(l, r);
        }

        public ITypeCheckExpr Multiply(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new MultiplyExpr(l, r);
        }

        public ITypeCheckExpr Divide(ITypeCheckExpr l, ITypeCheckExpr r)
        {
            return new DivideExpr(l, r);
        }

        public ITypeCheckExpr NegateBool(ITypeCheckExpr e)
        {
            return new NegateBoolExpr(e);
        }

        public ITypeCheckExpr NegateNumeric(ITypeCheckExpr e)
        {
            return new NegateNumericExpr(e);
        }

        public ITypeCheckExpr VarDecl(string var, ITypeCheckType t)
        {
            return VarAssign(var, t, t.DefaultValue);
        }

        public ITypeCheckExpr VarAssign(string var, ITypeCheckType t, ITypeCheckExpr e)
        {
            return new VarInitExpr(var, t, e);
        }

        public ITypeCheckExpr IfElse(ITypeCheckExpr toEval, ITypeCheckExpr ifTrue, ITypeCheckExpr ifFalse)
        {
            return new IfElseExpr(toEval, ifTrue, ifFalse);
        }

        public ITypeCheckExpr ExpressionOrder(ITypeCheckExpr e)
        {
            return e; //TODO
        }

        public ITypeCheckStmnt Statements(ITypeCheckStmnt l, ITypeCheckStmnt r)
        {
            return new StatementsStmnt(l, r);
        }

        public ITypeCheckStmnt Form(string var, ITypeCheckStmnt s)
        {
            return new FormStmnt(var, s);
        }

        public ITypeCheckStmnt Question(string s, ITypeCheckExpr e)
        {
            return new QuestionStmnt(s, e);
        }

        public ITypeCheckStmnt Label(string s, ITypeCheckExpr e)
        {
            return new LabelStmnt(s, e);
        }

        public ITypeCheckStmnt If(ITypeCheckExpr toEval, ITypeCheckStmnt ifTrue)
        {
            return new IfStmnt(toEval, ifTrue);
        }

        public ITypeCheckStmnt IfElse(ITypeCheckExpr toEval, ITypeCheckStmnt ifTrue, ITypeCheckStmnt ifFalse)
        {
            return new IfElseStmnt(toEval, ifTrue, ifFalse);
        }

        public ITypeCheckStmnt Block(ITypeCheckStmnt s)
        {
            return s; //TODO
        }
    }
}
