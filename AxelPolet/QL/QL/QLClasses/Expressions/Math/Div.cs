using System;

namespace QL.QLClasses.Expressions.Math
{
    public class Div : MathExpression
    {
        public override object Result()
        {
            return Convert.ToInt32(LeftValue.GetValue()) / Convert.ToInt32(RightValue.GetValue());
        }
    }
}
