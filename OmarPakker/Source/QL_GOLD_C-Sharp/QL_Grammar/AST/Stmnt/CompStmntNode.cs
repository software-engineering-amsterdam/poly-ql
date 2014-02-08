using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;

namespace QL_Grammar.AST.Stmnt
{
    public class CompStmntNode<S> : IStmntNode
        where S : IStmntNode
    {
        public ReadOnlyCollection<S> Statements { get; private set; }

        public CompStmntNode(params S[] stmnts)
        {
            List<S> statements = new List<S>();

            foreach (IStmntNode stmnt in stmnts)
            {
                if (stmnt is CompStmntNode<S>)
                {
                    statements.AddRange(((CompStmntNode<S>)stmnt).Statements);
                }
                else
                {
                    statements.Add((S)stmnt);
                }
            }

            Statements = statements.AsReadOnly();
        }
    }
}
