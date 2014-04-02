using System.Windows.Controls;
using System.Windows;
using System;
using QSLib.GUI;
using QSLib.Visitors;
namespace QSLib.AST.Types
{
    public abstract class QSType 
    {
        public abstract string Name { get; }

        public virtual bool IsCompatible(QSType other)
        {
            return false;
        }

        public virtual bool IsBoolean()
        {
            return false;
        }

        public virtual bool IsString()
        {
            return false;
        }

        public virtual bool IsInteger()
        {
            return false;
        }
        public abstract object Accept<T>(ITypeVisitor<T> visitor);
        public abstract object GetUndefined();
    }
}
