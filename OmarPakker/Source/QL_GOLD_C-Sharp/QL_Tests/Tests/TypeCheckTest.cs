using Algebra.QL.TypeCheck.Expr;
using Algebra.QL.TypeCheck.Factory;
using Algebra.QL.TypeCheck.Helpers;
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
            ITypeCheckStmnt smnt = tcFactory.Label("Test", tcFactory.Variable(varName));
            
            TypeEnvironment te = new TypeEnvironment();
            ErrorReporter errRep = new ErrorReporter();
            smnt.TypeCheck(te, errRep);

            Assert.False(te.IsVarDeclared(varName));
            Assert.True(errRep.HasErrors);
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
            
            TypeEnvironment te = new TypeEnvironment();
            ErrorReporter errRep = new ErrorReporter();
            stmnt.TypeCheck(te, errRep);

            Assert.True(te.IsVarDeclared(varName));
            Assert.True(errRep.HasErrors);
        }

        [Fact]
        public void DetectsNonBoolConditions()
        {
            ITypeCheckExpr expr = tcFactory.IfElse(tcFactory.Int(5), tcFactory.String("True"), tcFactory.String("False"));

            TypeEnvironment te = new TypeEnvironment();
            ErrorReporter errRep = new ErrorReporter();
            expr.TypeCheck(te, errRep);

            Assert.True(errRep.HasErrors);
        }

        [Fact]
        public void DetectsInvalidOperandsInOperation()
        {
            ITypeCheckExpr expr = tcFactory.Add(tcFactory.Bool(true), tcFactory.Bool(false));

            TypeEnvironment te = new TypeEnvironment();
            ErrorReporter errRep = new ErrorReporter();
            expr.TypeCheck(te, errRep);

            Assert.True(errRep.HasErrors);
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

            TypeEnvironment te = new TypeEnvironment();
            ErrorReporter errRep = new ErrorReporter();
            errRep.OnTypeCheckError += (start, end, msg, isError) => Assert.False(isError);
            stmnt.TypeCheck(te, errRep);

            Assert.True(te.IsVarDeclared(varName));
            Assert.False(errRep.HasErrors);
        }
    }
}
