using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Data;
using System.Windows;
using System.Windows.Controls;
namespace QSLib
{
    public class NotBoolToVisibilityConverter : IValueConverter
    {

        public object Convert(object value, Type targetType, object parameter, System.Globalization.CultureInfo culture)
        {
            BooleanToVisibilityConverter converter = new BooleanToVisibilityConverter();
            bool? convertValue = value as bool?;
            if (convertValue == null)
                return false;
            return converter.Convert(!convertValue, targetType, parameter, culture);
        }

        public object ConvertBack(object value, Type targetType, object parameter, System.Globalization.CultureInfo culture)
        {
            Visibility convertValue = (Visibility)value;
            if (convertValue == Visibility.Visible)
                return false;
            else
                return true;
        }
    }
}
