using System.Windows;
using System.Windows.Controls;
using QSLib.GUI;
using QSLib.AST.Types;
using QSLib.Visitors;

namespace QSLib.AST.Types
{
    public class StringType : QSType
    {
        public override string Name
        {
            get { return "String"; }
        }

        public override bool IsCompatible(QSType other)
        {
            if (other == null)
                return false;
            return other.IsString();
        }

        public override bool IsString()
        {
            return true;
        }

        public override string ToString()
        {
            return "string";
        }


        public override object Accept<T>(ITypeVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }


        public override object GetUndefined()
        {
            return "";
        }
    }
}
