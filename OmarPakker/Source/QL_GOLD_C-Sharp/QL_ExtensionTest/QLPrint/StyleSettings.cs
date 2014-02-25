using System.Windows;
using System.Windows.Media;

namespace QL_ExtensionTest.QLPrint
{
    public static class StyleSettings
    {
        public static readonly Brush KeyWordColor = new SolidColorBrush(Color.FromRgb(86, 156, 156));
        public static readonly Brush ReferenceColor = new SolidColorBrush(Color.FromRgb(60, 200, 130));
        public static readonly Brush QuestionStringColor = new SolidColorBrush(Color.FromRgb(214, 158, 132));

        public static readonly Thickness Intendation = new Thickness(25, 0, 0, 0);
    }
}
