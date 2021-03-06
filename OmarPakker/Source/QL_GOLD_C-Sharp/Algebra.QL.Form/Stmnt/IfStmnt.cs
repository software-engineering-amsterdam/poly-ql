﻿using System;
using System.Windows;
using System.Windows.Controls;
using Algebra.QL.Core.Stmnt;
using Algebra.QL.Eval.Environment;
using Algebra.QL.Eval.Value;
using Algebra.QL.Form.Environment;
using Algebra.QL.Form.Expr;

namespace Algebra.QL.Form.Stmnt
{
    public class IfStmnt : IfStmnt<IFormExpr, IFormStmnt>, IFormStmnt
    {
        public IfStmnt(IFormExpr check, IFormStmnt ifTrue)
            : base(check, ifTrue)
        {

        }

        public FrameworkElement BuildForm(IValueEnvironment vEnv, ITypeEnvironment tEnv)
        {
            ValueContainer value = CheckExpression.Evaluate(vEnv);

            StackPanel sp = new StackPanel();
            Action onValueChanged = () =>
            {
                sp.Visibility = Convert.ToBoolean(value.Value) ? Visibility.Visible : Visibility.Collapsed;
            };
            value.ValueChanged += onValueChanged;
            onValueChanged();

            sp.Children.Add(IfTrueBody.BuildForm(vEnv, tEnv));
            
            return sp;
        }
    }
}
