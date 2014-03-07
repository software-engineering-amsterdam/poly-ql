using System;
using Algebra.QL.TypeCheck.Expr;

namespace Algebra.QL.TypeCheck.Type
{
	//TODO: Get rid of UnknownType?
    public class UnknownType : ITypeCheckType
    {
        public Tuple<int, int> SourceStartPosition { get; set; }
        public Tuple<int, int> SourceEndPosition { get; set; }
        public ITypeCheckExpr DefaultValue { get { return null; } }
        public ITypeCheckType SuperType { get { return null; } }

        public UnknownType()
        {

        }
        
        public bool CompatibleWith(ITypeCheckType other)
        {
            return true;
        }

        public bool IsChildOf(ITypeCheckType other)
        {
            return true;
        }

        public ITypeCheckType GetLeastUpperBound(ITypeCheckType other)
        {
            return other;
        }

        public override string ToString()
        {
            return "unknown";
        }
    }
}
