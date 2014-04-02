using System.Windows;
using System.Windows.Controls;
using System;
using QSLib.GUI;
using QSLib.Visitors;
namespace QSLib.AST.Types
{
    public class IntegerType : QSType
    {
        public override string Name
        {
            get { return "Number"; }
        }

        public override bool IsCompatible(QSType other)
        {
            if (other == null)
                return false;
            return other.IsInteger();
        }

        public override bool IsInteger()
        {
            return true;
        }

        public override string ToString()
        {
            return "integer";
        }


        public override object Accept<T>(ITypeVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override object GetUndefined()
        {
            return 0;
        }
    }
}
