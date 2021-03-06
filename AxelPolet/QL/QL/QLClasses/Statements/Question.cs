﻿using QL.Interpreter;
using QL.QLClasses.Types;
using QL.TypeChecker;

namespace QL.QLClasses.Statements
{
    public class Question : StatementBase
    {
        protected string Name;
        protected string Label;
        protected QType Type;
        protected QLMemory Memory;

        public Question(QLMemory memory, string name, string label, QType type)
        {
            Memory = memory;
            Name = name;
            Label = label;
            Type = type;
        }

        #region TypeChecker Implementation

        public override bool CheckType(QLTypeErrors typeErrors)
        {
            if (Memory.IsDeclared(Name))
            {
                typeErrors.ReportError(new QLTypeError(
                    string.Format("(Question) Identifier '{0}' is already defined!", Name),
                    TokenInfo
                ));

                return false;
            }

            Memory.Declare(Name, Type);

            if (Memory.LabelIsDeclared(Label))
            {
                typeErrors.ReportError(new QLTypeError(
                    string.Format("(Question) Declared label already exists: '{0}'", Label),
                    TokenInfo,
                    true
                ));
            }

            Memory.DeclareLabel(Label);

            DeclareValue();
            
            return true;
        }

        protected virtual void DeclareValue()
        {
            Memory.DeclareValue(Name, Type.UndefinedValue());
        }

        #endregion

        #region Builder Implementation

        public override void Build(QLGuiBuilder guiBuilder)
        {
            guiBuilder.BuildQuestion(Memory, Name, Label);
        }

        #endregion
    }
}