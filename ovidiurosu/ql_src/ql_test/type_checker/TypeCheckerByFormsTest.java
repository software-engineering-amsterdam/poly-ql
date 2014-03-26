package ql_test.type_checker;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import ql.error.ErrorList;
import ql.error.Notice;
import ql.main.Parser;

/**
 * @author orosu
 */
public class TypeCheckerByFormsTest extends TypeCheckerTest
{
    @Override
    protected ParseTree _createParseTree(Parser parser)
    {
        return parser.forms();
    }

    @Test
    public void testDuplicateFormIds()
    {
        ErrorList errorList = new ErrorList();
        errorList.add(new Notice("This Questionnaire ID ('a') is not unique!"));
        this._testTypeChecker("duplicate_form_ids", errorList);
    }
}
