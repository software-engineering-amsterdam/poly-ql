using System.Collections.Generic;
using QL_Grammar.AST.Expr;
using QL_Grammar.AST.Stmnt;
using QL_Grammar.AST.Types;
using QL_Grammar.AST.Value;

namespace QL_Grammar.Factory
{
    public abstract class BaseFactory<E, S> : IFactory<E, S>
        where E : IExprNode
        where S : IStmntNode
    {
        protected Dictionary<string, E> Variables { get; private set; }
        protected Dictionary<string, S> Forms { get; private set; }

        public BaseFactory()
        {
            Variables = new Dictionary<string, E>();
            Forms = new Dictionary<string, S>();
        }

        public E String(string s)
        {
            return Literal(new StringValue(s));
        }

        public E Int(int i)
        {
            return Literal(new IntValue(i));
        }

        public E Real(double d)
        {
            return Literal(new RealValue(d));
        }

        public E Bool(bool b)
        {
            return Literal(new BoolValue(b));
        }

        public E Variable(string var)
        {
            if(!Variables.ContainsKey(var))
            {
                Variables[var] = VarDecl(var, UnknownType.Instance);
            }

            return Variables[var];
        }

        public abstract E Literal(IValue value);
        
        public abstract E Or(E l, E r);
        public abstract E And(E l, E r);
        public abstract E Eq(E l, E r);
        public abstract E NotEq(E l, E r);
        public abstract E LessThen(E l, E r);
        public abstract E GreaterThen(E l, E r);
        public abstract E LessOrEqualTo(E l, E r);
        public abstract E GreaterOrEqualTo(E l, E r);

        public abstract E Add(E l, E r);
        public abstract E Subtract(E l, E r);
        public abstract E Multiply(E l, E r);
        public abstract E Divide(E l, E r);

        public abstract E Negate(E e);

        public virtual E VarDecl(string var, IType t)
        {
            return VarAssign(var, t, Literal(t.DefaultValue));
        }

        public abstract E VarAssign(string var, IType t, E e);

        public abstract E IfElse(E toEval, E ifTrue, E ifFalse);

        public abstract S Form(string var, S s);
        public abstract S Goto(string var);

        public abstract S Comp(S l, S r);
        public abstract S Question(string s, bool b, E e);
        public abstract S If(E toEval, S ifTrue);
        public abstract S IfElse(E toEval, S ifTrue, S ifFalse);
    }
}
