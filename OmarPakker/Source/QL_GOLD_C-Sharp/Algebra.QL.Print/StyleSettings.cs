using System.Windows.Media;

namespace Algebra.QL.Print
{
    public static class StyleSettings
    {
        public static readonly int IntendationAmount = 25;

        public static readonly Brush KeyWordColor = new SolidColorBrush(Color.FromRgb(86, 156, 156));
        public static readonly Brush ReferenceColor = new SolidColorBrush(Color.FromRgb(60, 200, 130));
        public static readonly Brush QuestionStringColor = new SolidColorBrush(Color.FromRgb(214, 158, 132));
    }
}
