namespace QL_Csharp.PrimitiveControls
{
    public partial class StringControl : StatementControl, IPrimitiveControl<string>
    {
        public StringControl(string labelName)
        {
            InitializeComponent();
            label.Text = labelName;
        }

        public string GetValue()
        {
            return textBoxValue.Text;
        }
    }
}