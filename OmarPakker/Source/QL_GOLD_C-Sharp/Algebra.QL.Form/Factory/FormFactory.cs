using Algebra.QL.Core.Factory;
using Algebra.QL.Form.Expr;
using Algebra.QL.Form.Expr.Literals;
using Algebra.QL.Form.Stmnt;
using Algebra.QL.Form.Type;

namespace Algebra.QL.Form.Factory
{
    public class FormFactory : IStmntFactory<IFormStmnt, IFormExpr, IFormType>
    {
        public FormFactory()
        {
            
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
            return new VarExpr(var);
        }

        public IFormExpr Or(IFormExpr l, IFormExpr r)
        {
            return new OrExpr(l, r);
        }

        public IFormExpr And(IFormExpr l, IFormExpr r)
        {
            return new AndExpr(l, r);
        }

        public IFormExpr Eq(IFormExpr l, IFormExpr r)
        {
            return new EqualsExpr(l, r);
        }

        public IFormExpr NotEq(IFormExpr l, IFormExpr r)
        {
            return new NotEqualExpr(l, r);
        }

        public IFormExpr LessThen(IFormExpr l, IFormExpr r)
        {
            return new LessThenExpr(l, r);
        }

        public IFormExpr GreaterThen(IFormExpr l, IFormExpr r)
        {
            return new GreaterThenExpr(l, r);
        }

        public IFormExpr LessOrEqualTo(IFormExpr l, IFormExpr r)
        {
            return new LessOrEqualToExpr(l, r);
        }

        public IFormExpr GreaterOrEqualTo(IFormExpr l, IFormExpr r)
        {
            return new GreaterOrEqualToExpr(l, r);
        }

        public IFormExpr Add(IFormExpr l, IFormExpr r)
        {
            return new AddExpr(l, r);
        }

        public IFormExpr Subtract(IFormExpr l, IFormExpr r)
        {
            return new SubtractExpr(l, r);
        }

        public IFormExpr Multiply(IFormExpr l, IFormExpr r)
        {
            return new MultiplyExpr(l, r);
        }

        public IFormExpr Divide(IFormExpr l, IFormExpr r)
        {
            return new DivideExpr(l, r);
        }

        public IFormExpr NegateBool(IFormExpr e)
        {
            return new NegateBoolExpr(e);
        }

        public IFormExpr NegateNumeric(IFormExpr e)
        {
            return new NegateNumericExpr(e);
        }

        public IFormExpr VarDecl(string var, IFormType t)
        {
            return new VarInitExpr(var, t);
        }

        public IFormExpr VarAssign(string var, IFormType t, IFormExpr e)
        {
            return new VarInitExpr(var, t, e);
        }

        public IFormExpr IfElse(IFormExpr toEval, IFormExpr ifTrue, IFormExpr ifFalse)
        {
            return new IfElseExpr(toEval, ifTrue, ifFalse);
        }

        public IFormExpr ExpressionOrder(IFormExpr e)
        {
            return e; //TODO
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
            return s; //TODO
        }
    }
}
