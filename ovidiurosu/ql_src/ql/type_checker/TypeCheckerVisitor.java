package ql.type_checker;

import java.util.List;
import java.util.Set;

import ql.ast.Questionnaire;
import ql.ast.expression.BinaryExpression;
import ql.ast.expression.Id;
import ql.ast.expression.ParenthesesExpression;
import ql.ast.expression.UnaryExpression;
import ql.ast.expression.arithmetic.Add;
import ql.ast.expression.arithmetic.Divide;
import ql.ast.expression.arithmetic.Multiply;
import ql.ast.expression.arithmetic.Remainder;
import ql.ast.expression.arithmetic.Subtract;
import ql.ast.expression.arithmetic.UnaryMinus;
import ql.ast.expression.arithmetic.UnaryPlus;
import ql.ast.expression.comparison.Equal;
import ql.ast.expression.comparison.GreaterThan;
import ql.ast.expression.comparison.GreaterThanEqual;
import ql.ast.expression.comparison.LessThan;
import ql.ast.expression.comparison.LessThanEqual;
import ql.ast.expression.comparison.NotEqual;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.NumberLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.logical.LogicalAnd;
import ql.ast.expression.logical.LogicalOr;
import ql.ast.expression.logical.Not;
import ql.ast.statement.Assignment;
import ql.ast.statement.ComputedAssignment;
import ql.ast.statement.IAssignment;
import ql.ast.statement.IStatement;
import ql.ast.statement.IfStatement;
import ql.ast.type.IntegerType;
import ql.ast.visitor_elements.IElementVisitor;
import ql.error.IError;

/**
 * @author orosu
 */
public class TypeCheckerVisitor extends Checker implements IElementVisitor<Void>
{
    public TypeCheckerVisitor()
    {
        super();
    }

    public TypeCheckerVisitor(List<Questionnaire> checkedQuestionnaires)
    {
        super(checkedQuestionnaires);
    }

    public Set<IError> getErrors()
    {
        return this._typeEnvironment.getErrors();
    }

    @Override
    public Void visit(Questionnaire questionnaire)
    {
        // Check if the ID of this questionnaire is unique
        new QuestionnaireListChecker(this._typeEnvironment, questionnaire)
            .checkIdForDuplicates();

        for(IStatement statement: questionnaire.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Assignment assignment)
    {
        this._checkAssignment(assignment);

        this._typeEnvironment.addAssign(assignment.getId(), assignment);
        return null;
    }

    @Override
    public Void visit(ComputedAssignment computedAssignment)
    {
        this._checkAssignment(computedAssignment);

        new AssignmentChecker(this._typeEnvironment, computedAssignment)
            .checkCyclicDependencies(computedAssignment.getExpression());

        // Visit Expression
        computedAssignment.getExpression().accept(this);

        // Check if the statement's type is compatible with the expression's type
        new ExpressionChecker(this._typeEnvironment, computedAssignment.getExpression())
            .checkTypeCompatibility(computedAssignment.getType());

        this._typeEnvironment.addAssign(computedAssignment.getId(), computedAssignment);
        return null;
    }

    @Override
    public Void visit(IfStatement ifStatement)
    {
        // Visit Expression
        ifStatement.getExpression().accept(this);

        // Check if the statement's type is compatible with the expression's type
        new ExpressionChecker(this._typeEnvironment, ifStatement.getExpression())
            .checkTypeCompatibility(ifStatement.getType());

        // Visit if statements
        for (IStatement statement: ifStatement.getIfStatements()) {
            statement.accept(this);
        }

        // Visit else statements
        for (IStatement statement: ifStatement.getElseStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Id id)
    {
        id.setTypeEnvironment(this._typeEnvironment);

        new ExpressionChecker(this._typeEnvironment, id)
            .checkIdHasType();
        return null;
    }

    @Override
    public Void visit(Add add)
    {
        return this._checkBinaryExpression(add);
    }

    @Override
    public Void visit(Divide divide)
    {
        return this._checkBinaryExpression(divide);
    }

    @Override
    public Void visit(Multiply multiply)
    {
        return this._checkBinaryExpression(multiply);
    }

    @Override
    public Void visit(Remainder remainder)
    {
        return this._checkBinaryExpression(remainder);
    }

    @Override
    public Void visit(Subtract subtract)
    {
        return this._checkBinaryExpression(subtract);
    }

    @Override
    public Void visit(LogicalAnd logicalAnd)
    {
        return this._checkBinaryExpression(logicalAnd);
    }

    @Override
    public Void visit(LogicalOr logicalOr)
    {
        return this._checkBinaryExpression(logicalOr);
    }

    @Override
    public Void visit(Equal equal)
    {
        return this._checkEqualityExpression(equal);
    }

    @Override
    public Void visit(NotEqual notEqual)
    {
        return this._checkEqualityExpression(notEqual);
    }

    @Override
    public Void visit(GreaterThan greaterThan)
    {
        return this._checkRelationalExpression(greaterThan);
    }

    @Override
    public Void visit(GreaterThanEqual greaterThanEqual)
    {
        return this._checkRelationalExpression(greaterThanEqual);
    }

    @Override
    public Void visit(LessThan lessThan)
    {
        return this._checkRelationalExpression(lessThan);
    }

    @Override
    public Void visit(LessThanEqual lessThanEqual)
    {
        return this._checkRelationalExpression(lessThanEqual);
    }

    @Override
    public Void visit(Not not)
    {
        return this._checkUnaryExpression(not);
    }

    @Override
    public Void visit(UnaryMinus unaryMinus)
    {
        return this._checkUnaryExpression(unaryMinus);
    }

    @Override
    public Void visit(UnaryPlus unaryPlus)
    {
        return this._checkUnaryExpression(unaryPlus);
    }

    @Override
    public Void visit(BooleanLiteral booleanLiteral)
    {
        // Do nothing!
        return null;
    }

    @Override
    public Void visit(NumberLiteral numberLiteral)
    {
        // Do nothing!
        return null;
    }

    @Override
    public Void visit(StringLiteral stringLiteral)
    {
        // Do nothing!
        return null;
    }

    @Override
    public Void visit(ParenthesesExpression parenthesesExpression)
    {
        // Do nothing!
        return null;
    }

    private Void _checkAssignment(IAssignment assignment)
    {
        // Check if the ID or the label of this assignment is unique
        AssignmentChecker checker = new AssignmentChecker(this._typeEnvironment, assignment);
        checker.checkIdForDuplicates();
        checker.checkLabelForDuplicates();
        return null;
    }

    private Void _checkUnaryExpression(UnaryExpression unaryExpression)
    {
        // Visit Expression
        unaryExpression.getExpression().accept(this);

        // Check if the child expression's type is compatible with the expression's type
        new ExpressionChecker(this._typeEnvironment, unaryExpression.getExpression())
            .checkTypeCompatibility(unaryExpression.getType());
        return null;
    }

    private Void _checkBinaryExpression(BinaryExpression binaryExpression)
    {
        // Visit Left and Right Subexpressions
        binaryExpression.getLeftSubExpression().accept(this);
        binaryExpression.getRightSubExpression().accept(this);

        // Check if the left subexpression's type is compatible with the parent expression's type
        new ExpressionChecker(this._typeEnvironment, binaryExpression.getLeftSubExpression())
            .checkTypeCompatibility(binaryExpression.getType());

        // Check if the right subexpression's type is compatible with the parent expression's type
        new ExpressionChecker(this._typeEnvironment, binaryExpression.getRightSubExpression())
            .checkTypeCompatibility(binaryExpression.getType());
        return null;
    }

    private Void _checkEqualityExpression(BinaryExpression equalityExpression)
    {
        // Visit Left and Right Subexpressions
        equalityExpression.getLeftSubExpression().accept(this);
        equalityExpression.getRightSubExpression().accept(this);

        // Check if the left subexpression's type is compatible with the right expression's type
        new ExpressionChecker(this._typeEnvironment, equalityExpression.getLeftSubExpression())
            .checkTypeCompatibility(equalityExpression.getRightSubExpression().getType());
        return null;
    }

    private Void _checkRelationalExpression(BinaryExpression relationalExpression)
    {
        // Visit Left and Right Subexpressions
        relationalExpression.getLeftSubExpression().accept(this);
        relationalExpression.getRightSubExpression().accept(this);

        // Check if the left subexpression's type is compatible with the parent expression's type
        new ExpressionChecker(this._typeEnvironment, relationalExpression.getLeftSubExpression())
            .checkTypeCompatibility(new IntegerType());

        // Check if the right subexpression's type is compatible with the parent expression's type
        new ExpressionChecker(this._typeEnvironment, relationalExpression.getRightSubExpression())
            .checkTypeCompatibility(new IntegerType());
        return null;
    }
}
