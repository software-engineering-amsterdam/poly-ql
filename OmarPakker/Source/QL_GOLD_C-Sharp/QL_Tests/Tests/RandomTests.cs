using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xunit;

namespace QL_Tests.Tests
{
    public class RandomTests
    {
        private const string TestString = "This actually works!";

        public RandomTests()
        {

        }

        [Fact]
        public void FuncCanBeUsedToSimulateAnonymousFunctions()
        {
            var t = new { Function = new Func<string>(() => TestString) };

            Assert.Equal(t.Function(), TestString);
        }

        [Fact]
        public void ActionCanBeUsedToSimulateAnonymousFunctions()
        {
            string resultString = String.Empty;
            var t = new { Action = new Action<string>((s) => resultString = s) };
            t.Action(TestString);

            Assert.Equal(resultString, TestString);
        }
    }
}
