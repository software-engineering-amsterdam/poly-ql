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

            Width = 200;
            Height = 20;
        }

        public abstract void Render();
    }
}
