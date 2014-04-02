using System.Windows;
using System.Windows.Controls;
using System;
using QSLib.GUI;
using QSLib.Visitors;
namespace QSLib.AST.Types
{
    public class BoolType : QSType
    {
        public override string Name
        {
            get { return "Boolean"; }
        }

        public override bool IsCompatible(QSType other)
        {
            if (other == null)
                return false;
            return other.IsBoolean();
        }

        public override object Accept<T>(ITypeVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override bool IsBoolean()
        {
            return true;
        }

        public override string ToString()
        {
            return "boolean";
        }

        public override object GetUndefined()
        {
            return false;
        }

    }
}
