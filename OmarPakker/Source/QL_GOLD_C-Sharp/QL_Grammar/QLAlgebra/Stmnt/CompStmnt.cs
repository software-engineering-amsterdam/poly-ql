using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace QL_Grammar.QLAlgebra.Stmnt
{
    public abstract class CompStmnt<S>
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public ReadOnlyCollection<S> Statements { get; private set; }

        public CompStmnt(params S[] stmnts)
        {
            List<S> statements = new List<S>();

			foreach (S stmnt in stmnts)
            {
                if (stmnt is CompStmnt<S>)
                {
                    statements.AddRange((stmnt as CompStmnt<S>).Statements);
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
			if (!(obj is CompStmnt<S>))
			{
				return false;
			}

			CompStmnt<S> other = (CompStmnt<S>)obj;

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
