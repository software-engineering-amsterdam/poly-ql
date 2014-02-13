using System;

namespace QL_Grammar.AST.Stmnt
{
    public abstract class FormStmntNode<S> : IStmntNode
        where S : IStmntNode
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public string Name { get; private set; }
        public S Body { get; private set; }

        public FormStmntNode(string name, S body)
        {
            Name = name;
            Body = body;
        }

		public override bool Equals(object obj)
		{
			if (!(obj is FormStmntNode<S>))
			{
				return false;
			}

			FormStmntNode<S> other = (FormStmntNode<S>)obj;
			return Name.Equals(other.Name) && Body.Equals(other.Body);
		}

		public override int GetHashCode()
		{
			return Name.GetHashCode() + Body.GetHashCode();
		}
    }
}
