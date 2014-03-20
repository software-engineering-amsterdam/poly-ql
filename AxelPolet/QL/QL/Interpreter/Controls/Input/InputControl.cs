using System.Windows;
using System.Windows.Controls;

namespace QL.Interpreter.Controls.Input
{
    public abstract class InputControl : StackPanel
    {
        protected readonly QLMemory Memory;
        protected readonly string IdName;
        protected readonly bool IsComputed;

        public GUIQuestion.ChangedEventHandler OnChanged { get; set; }

        protected InputControl(string idName, QLMemory memory, bool isComputed = false)
        {
            Memory = memory;
            IdName = idName;
            IsComputed = isComputed;

            //ui properties
            Width = 325;
            Height = 20;
            Margin = new Thickness(25, 0, 0, 0);
        }

        public abstract void Render();
    }
}
