using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows.Data;

namespace QSLib
{
    public class NotConverter : IValueConverter
    {

        public object Convert(object value, Type targetType, object parameter, System.Globalization.CultureInfo culture)
        {
            bool? convertValue = value as bool?;
            if (convertValue == null)
                return false;
            return !convertValue;
        }

        public object ConvertBack(object value, Type targetType, object parameter, System.Globalization.CultureInfo culture)
        {
            bool? convertValue = value as bool?;
            if (convertValue == null)
                return false;
            return !convertValue;
        }
    }
}
