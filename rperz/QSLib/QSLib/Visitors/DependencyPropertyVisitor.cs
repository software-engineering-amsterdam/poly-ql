using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using QSLib.AST.Types;
using System.Windows.Controls;
using QSLib.GUI.Converters;
using System.Windows.Data;
namespace QSLib.Visitors
{
    public class DependencyPropertyVisitor : ITypeVisitor<DependencyProperty>
    {
        public DependencyProperty Visit(IntegerType type)
        {
            return TextBox.TextProperty;
        }
        public DependencyProperty Visit(StringType type)
        {
            return TextBox.TextProperty;
        }
        public DependencyProperty Visit(BoolType type)
        {
            return CheckBox.IsCheckedProperty;
        }
    }
    public class ConverterVisitor : ITypeVisitor<IValueConverter>
    {
        public IValueConverter Visit(IntegerType type)
        {
            return new StringToIntegerConverter();
        }
        public IValueConverter Visit(StringType type)
        {
            return null;
        }
        public IValueConverter Visit(BoolType type)
        {
            return new StringToBooleanConverter();
        }
    }
}
