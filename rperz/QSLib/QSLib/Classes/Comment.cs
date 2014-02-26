using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions;
using QSLib.Expressions.Types;
namespace QSLib
{
    public class Comment : IStatement
    {
        private String _text;
        private int _linenr;
        public Comment(String text, int linenr)
        {
            this._text = text;
            this._linenr = linenr;
        }

        public override string ToString()
        {
            return this._text.ToString();
        }

        public Type Type
        {
            get
            {
                return new Comment("", 1).GetType();
            }
        }
        public bool CheckType()
        {
            return true;
        }

        public override bool Equals(object obj)
        {
            var comp = obj as Comment;
            if (comp == null)
                return false;
            return comp.Type.Equals(this.Type);

        }
    }
}
