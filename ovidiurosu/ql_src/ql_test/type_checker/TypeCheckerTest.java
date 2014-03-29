package ql_test.type_checker;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.antlr.v4.runtime.tree.ParseTree;

import ql.ast.AstBuilderVisitor;
import ql.ast.Questionnaire;
import ql.ast.QuestionnaireList;
import ql.error.ErrorList;
import ql.error.IError;
import ql.main.Parser;
import ql.type_checker.TypeCheckerVisitor;
import ql_test.QlTest;

/**
 * @author orosu
 */
public abstract class TypeCheckerTest
{
    protected final String _testFilesPath = System.getProperty("user.dir") +
        File.separator + "src" + File.separator + "ql_test" + File.separator +
        "type_checker_test_files" + File.separator;

    public TypeCheckerTest()
    {
    }

    protected void _testTypeChecker(String fileName, ErrorList errorList)
    {
        File testFile = new File(this._testFilesPath + fileName);
        if (!QlTest.checkFile(testFile)) { return; }

        try {
            Parser parser = new Parser();
            parser.buildQLParser(testFile);
            ParseTree parseTree = this._createParseTree(parser);

            ErrorList typeChekerErrorList = this._buildAndCheck(parseTree);
            org.junit.Assert.assertEquals("FAIL! The provided number of errors should " +
                "be equal to the number of errors found by the type checker!",
                typeChekerErrorList.size(), errorList.size());

            for (int i = 0; i < errorList.size(); i++) {
                IError typeCheckerError = typeChekerErrorList.get(i);
                org.junit.Assert.assertTrue("FAIL! This error (" +
                    typeCheckerError.getMessage() + ") is not found by the type checker!",
                    typeCheckerError.equals(errorList.get(i)));
            }
        } catch (IOException exc) {
            fail("ATTENTION! " + exc.getMessage());
        }
    }

    protected ParseTree _createParseTree(Parser parser)
    {
        return parser.forms();
    }

    protected ErrorList _buildAndCheck(ParseTree parseTree)
    {
        ErrorList errorList = new ErrorList();

        AstBuilderVisitor buildAstVisitor = new AstBuilderVisitor();
        QuestionnaireList questionnaires = (QuestionnaireList) buildAstVisitor.visit(parseTree);

        QuestionnaireList checkedQuestionnaires = new QuestionnaireList();
        Iterator<Questionnaire> iterator = questionnaires.iterator();
        while (iterator.hasNext()) {
            Questionnaire questionnaire = iterator.next();

            TypeCheckerVisitor typeCheckerVisitor = new TypeCheckerVisitor(checkedQuestionnaires);
            typeCheckerVisitor.visit(questionnaire);
            errorList.addAll(typeCheckerVisitor.getErrorList());

            checkedQuestionnaires.add(questionnaire);
        }

        return errorList;
    }
}
