using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using QSLib.Expressions.Unary;
using QSLib.Expressions;
using System.Windows.Controls;

namespace QSLib
{
    public class GUIBuilder
    {
        private ItemsControl _control;
        private Control _currentQuestion;

        private GUIBuilder()
        {
 
        }

        public void AddQuestion()
        {
            this._currentQuestion = new QuestionControl();
        }

        public void CreateQuestion(string text)
        {
            
        }

        public void SetStringInput(Identifier id)
        {

        }

        public void SetIntegerInput(Identifier id)
        {

        }

        public void SetBooleanInput(Identifier id)
        {

        }

        public void AddVisibleIfTrue(IExpression expr)
        {

        }

        public ItemsControl GetResult()
        {
            return this._control;
        }


    }
}
