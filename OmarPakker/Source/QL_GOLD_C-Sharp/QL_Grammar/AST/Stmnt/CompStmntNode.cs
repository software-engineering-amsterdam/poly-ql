using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace QL_Grammar.AST.Stmnt
{
    public abstract class CompStmntNode<S> : IStmntNode
        where S : IStmntNode
    {
		public Tuple<int, int> SourcePosition { get; set; }
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

		public override bool Equals(object obj)
		{
			if (!(obj is CompStmntNode<S>))
			{
				return false;
			}

			CompStmntNode<S> other = (CompStmntNode<S>)obj;

			if (Statements.Count != other.Statements.Count)
			{
				return false;
			}

			foreach (S stmnt in other.Statements)
			{
				if (!Statements.Contains(stmnt))
				{
					return false;
				}
			}

			return true;
		}

		public override int GetHashCode()
		{
			int hash = Statements.Count;
			foreach (S stmnt in Statements)
			{
				hash += stmnt.GetHashCode();
			}
			return hash;
		}
    }
}
