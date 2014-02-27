using System;

namespace Algebra.Core.Tree
{
    public interface INode
    {
        Tuple<int, int> SourcePosition { get; set; }
    }
}
