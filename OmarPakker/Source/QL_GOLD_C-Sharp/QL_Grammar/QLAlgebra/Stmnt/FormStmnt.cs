using System;

namespace QL_Grammar.QLAlgebra.Stmnt
{
    public abstract class FormStmnt<S>
    {
		public Tuple<int, int> SourcePosition { get; set; }
        public string Name { get; private set; }
        public S Body { get; private set; }

        public FormStmnt(string name, S body)
        {
            Name = name;
            Body = body;
        }

		public override bool Equals(object obj)
		{
			if (!(obj is FormStmnt<S>))
			{
				return false;
			}

			FormStmnt<S> other = (FormStmnt<S>)obj;
			return Name.Equals(other.Name) && Body.Equals(other.Body);
		}

		public override int GetHashCode()
		{
			return Name.GetHashCode() + Body.GetHashCode();
		}
    }
}
