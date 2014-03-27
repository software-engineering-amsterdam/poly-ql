using Algebra.Core.Environment;
using Algebra.QL.TypeCheck.Environment;
using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Factory;
using Algebra.QL.TypeCheck.Stmnt;
using Algebra.QL.TypeCheck.Type;
using Xunit;

namespace QL_Tests.Tests
{
    public class TypeCheckTest
    {
        private readonly TypeCheckFactory tcFactory;

        public TypeCheckTest()
        {
            tcFactory = new TypeCheckFactory();
        }

        [Fact]
        public void DetectsUndefinedQuestionUse()
        {
            string varName = "someVar";
            ITypeCheckStmnt stmnt = tcFactory.Label("Test", tcFactory.Variable(varName));

            ErrorManager errMngr = new ErrorManager();
            TypeEnvironment te = new TypeEnvironment(errMngr);
            stmnt.TypeCheck(te);

            Assert.False(te.IsDeclared(varName));
            Assert.True(errMngr.HasErrors);
        }

        [Fact]
        public void DetectsRedefinedQuestions()
        {
            string varName = "someVar";
            ITypeCheckType type1 = tcFactory.RealType();
            ITypeCheckType type2 = tcFactory.BoolType();

            ITypeCheckStmnt stmnt = tcFactory.Statements(
                tcFactory.Question("Test", tcFactory.VarDecl(varName, type1)),
                tcFactory.Question("Test", tcFactory.VarDecl(varName, type2))
            );

            ErrorManager errMngr = new ErrorManager();
            TypeEnvironment te = new TypeEnvironment(errMngr);
            stmnt.TypeCheck(te);

            Assert.True(te.IsDeclared(varName));
            Assert.True(errMngr.HasErrors);
        }

        [Fact]
        public void DetectsAssignmentOfInvalidType()
        {
            string varName = "someVar";

            ITypeCheckStmnt stmnt = tcFactory.Label("Test",
                tcFactory.VarAssign(varName, tcFactory.RealType(), tcFactory.Bool(true))
            );

            ErrorManager errMngr = new ErrorManager();
            TypeEnvironment te = new TypeEnvironment(errMngr);
            stmnt.TypeCheck(te);

            Assert.True(te.IsDeclared(varName));
            Assert.True(errMngr.HasErrors);
        }

        [Fact]
        public void DetectsNonBoolConditions()
        {
            ITypeCheckExpr expr = tcFactory.IfElse(tcFactory.Int(5), tcFactory.String("True"), tcFactory.String("False"));

            ErrorManager errMngr = new ErrorManager();
            expr.TypeCheck(new TypeEnvironment(errMngr));

            Assert.True(errMngr.HasErrors);
        }

        [Fact]
        public void DetectsIncompatibleOperandsInOperation()
        {
            ITypeCheckExpr expr = tcFactory.Add(tcFactory.Bool(true), tcFactory.Int(100));

            ErrorManager errMngr = new ErrorManager();
            expr.TypeCheck(new TypeEnvironment(errMngr));

            Assert.True(errMngr.HasErrors);
        }

        [Fact]
        public void DuplicateLabelsWarning()
        {
            string varName = "someVar";
            ITypeCheckType varType = tcFactory.IntType();

            ITypeCheckStmnt stmnt = tcFactory.Statements(
                tcFactory.Question("Test", tcFactory.VarDecl(varName, varType)),
                tcFactory.Question("Test", tcFactory.VarDecl(varName, varType))
            );

            ErrorManager errMngr = new ErrorManager();
            TypeEnvironment te = new TypeEnvironment(errMngr);
            stmnt.TypeCheck(te);

            Assert.True(te.IsDeclared(varName));
            Assert.True(errMngr.HasWarnings);
            Assert.False(errMngr.HasErrors);
        }

        [Fact]
        public void CyclicDependencyNotPossible()
        {
            string varName1 = "var1";
            string varName2 = "var2";
            ITypeCheckType type1 = tcFactory.RealType();
            ITypeCheckType type2 = tcFactory.BoolType();

            ITypeCheckStmnt stmnt = tcFactory.Statements(
                tcFactory.Label("Test", tcFactory.VarAssign(varName1, type1, tcFactory.Variable(varName2))),
                tcFactory.Label("Test", tcFactory.VarAssign(varName2, type2, tcFactory.Variable(varName1)))
            );

            ErrorManager errMngr = new ErrorManager();
            TypeEnvironment te = new TypeEnvironment(errMngr);
            stmnt.TypeCheck(te);

            Assert.True(te.IsDeclared(varName1));
            Assert.True(te.IsDeclared(varName2));
            Assert.True(errMngr.HasErrors);
        }
    }
}
