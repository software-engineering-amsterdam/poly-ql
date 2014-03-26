package ql_test.type_checker;

import java.util.Iterator;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import ql.ast.AstBuilderVisitor;
import ql.ast.QuestionnaireList;
import ql.ast.statement.Block;
import ql.ast.statement.IStatement;
import ql.error.ErrorList;
import ql.error.TypeError;
import ql.error.Warning;
import ql.main.Parser;
import ql.type_checker.TypeCheckerVisitor;

/**
 * @author orosu
 */
public class TypeCheckerByBlockTest extends TypeCheckerTest
{
    @Test
    public void testDuplicateAssignmentIds()
    {
        ErrorList errorList = new ErrorList();
        errorList.add(new TypeError("The ID 'a' is already used by another assignment "
                + "with a different type (type boolean)!"));
        this._testTypeChecker("duplicate_assignment_ids", errorList);
    }

    @Test
    public void testDuplicateAssignmentLabels()
    {
        ErrorList errorList = new ErrorList();
        errorList.add(new Warning("The label 'a' is already used by assignment with ID 'a'!"));
        this._testTypeChecker("duplicate_assignment_labels", errorList);
    }

    @Test
    public void testSimpleCyclicDependencies()
    {
        ErrorList errorList = new ErrorList();
        errorList.add(new TypeError("The id of this assignment ('x') is also used in "
                + "it's expression! Cyclic Dependencies!"));
        this._testTypeChecker("simple_cyclic_dependencies", errorList);
    }

    @Test
    public void testUndefinedId()
    {
        ErrorList errorList = new ErrorList();
        errorList.add(new TypeError("There is no assignment with id 'b'!"));
        errorList.add(new TypeError("An expression having '(type null)' is not "
                + "compatible with an expression having '(type integer)'!"));
        this._testTypeChecker("undefined_id", errorList);
    }

    @Test
    public void testExpressionTypeCompatibility()
    {
        ErrorList errorList = new ErrorList();
        errorList.add(new TypeError("An expression having '(type integer)' is not "
                + "compatible with an expression having '(type boolean)'!"));
        errorList.add(new TypeError("An expression having '(type boolean)' is not "
                + "compatible with an expression having '(type decimal)'!"));
        errorList.add(new TypeError("An expression having '(type boolean)' is not "
                + "compatible with an expression having '(type integer)'!"));
        errorList.add(new TypeError("An expression having '(type integer)' is not "
                + "compatible with an expression having '(type boolean)'!"));
        this._testTypeChecker("expression_type_compatibility", errorList);
    }

    @Override
    protected ParseTree _createParseTree(Parser parser)
    {
        return parser.block();
    }

    @Override
    protected ErrorList _buildAndCheck(ParseTree parseTree)
    {
        AstBuilderVisitor buildAstVisitor = new AstBuilderVisitor();
        TypeCheckerVisitor typeCheckerVisitor = new TypeCheckerVisitor(new QuestionnaireList());

        Block block = (Block) buildAstVisitor.visit(parseTree);
        Iterator<IStatement> statementListIterator = block.getStatementList().iterator();
        while (statementListIterator.hasNext()) {
            statementListIterator.next().accept(typeCheckerVisitor);
        }
        return typeCheckerVisitor.getErrorList();
    }
}
