using System;
using Antlr4.Runtime;
using QL.Interfaces;
using QL.TypeChecker;

namespace QL.QLClasses.Expressions
{
    public abstract class ExpressionBase : ITypeChecker
    {
        public int TokenLine { get; set; }
        public int TokenColumn { get; set; }
        public string TokenText { get; set; }

        public IToken Token
        {
            set { TokenLine = value.Line; TokenColumn = value.Column; TokenText = value.Text; }
        }

        public abstract bool CheckType(ref QLException error);
        public new abstract Type GetType();
        public abstract object Result();
    }
}
