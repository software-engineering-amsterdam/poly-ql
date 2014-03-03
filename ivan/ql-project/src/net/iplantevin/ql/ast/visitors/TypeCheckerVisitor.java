package net.iplantevin.ql.ast.visitors;

import net.iplantevin.ql.ast.ASTNode;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.expressions.Par;
import net.iplantevin.ql.ast.expressions.literals.Bool;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Int;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.expressions.operators.*;
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;
import net.iplantevin.ql.ast.statements.*;
import net.iplantevin.ql.ast.types.*;
import net.iplantevin.ql.errors.ASTError;
import net.iplantevin.ql.errors.DuplicateLabelError;
import net.iplantevin.ql.errors.TypeError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Visits and type checks AST. Errors are collected and can be printed through
 * printAllErrors().
 *
 * @author Ivan
 */
public class TypeCheckerVisitor implements IASTVisitor {
    private final List<ASTError> errors;
    private final TypeEnvironment idTypeStore;
    private final Map<String, Questionable> labels;
    private static UndefinedType UNDEFINED = new UndefinedType();

    private TypeCheckerVisitor() {
        errors = new ArrayList<ASTError>();
        idTypeStore = new TypeEnvironment();
        labels = new HashMap<String, Questionable>();
    }

    public static TypeCheckerVisitor checkNode(ASTNode node) {
        TypeCheckerVisitor typeChecker = new TypeCheckerVisitor();
        node.accept(typeChecker);
        return typeChecker;
    }

    /////////////////////////////////////////////
    // Error addition and printing
    /////////////////////////////////////////////
    private void addError(ASTError error) {
        errors.add(error);
    }

    public void printAllErrors() {
        for (ASTError error : errors) {
            System.out.println(error);
        }
    }

    /////////////////////////////////////////////
    // Label (duplication check) methods
    /////////////////////////////////////////////
    private void addQuestionableLabel(Questionable questionable) {
        Questionable originalQuestion = duplicateLabelQuestionable(questionable);
        if (originalQuestion != null) {
            // Label in given question is duplicate from earlier question.
            String message = "this label was already used!";
            DuplicateLabelError labelError = new DuplicateLabelError(
                    message,
                    questionable,
                    originalQuestion
            );
            addError(labelError);
        } else {
            labels.put(questionable.getLabel().getText(), questionable);
        }
    }

    private Questionable duplicateLabelQuestionable(Questionable questionable) {
        if (labels.containsKey(questionable.getLabel().getText())) {
            return labels.get(questionable.getLabel().getText());
        } else {
            return null;
        }
    }

    /////////////////////////////////////////////
    // Add identifier to type store
    /////////////////////////////////////////////
    private void addIdentifier(Questionable questionable) {
        TypeError typeError = idTypeStore.
                addIdentifier(questionable.getName(), questionable.getType());
        if (typeError != null) {
            addError(typeError);
        }
    }

    /////////////////////////////////////////////
    // Expression validator methods
    /////////////////////////////////////////////
    private void checkExpectedType(Expression expression, Type expectedType) {
        Type actualType = expression.getType(idTypeStore);

        if (actualType.equals(UNDEFINED)) {
            String message = "the expression below is undefined!";
            TypeError typeError = new TypeError(
                    message,
                    expression,
                    expectedType,
                    UNDEFINED
            );
            addError(typeError);

        } else if (!actualType.isCompatibleToType(expectedType)) {
            String message = "the type of the expression below is not compatible " +
                    "with the expected type!";
            TypeError typeError = new TypeError(
                    message,
                    expression,
                    expectedType,
                    expression.getType(idTypeStore)
            );
            addError(typeError);
        }
    }

    private void checkComputation(Computation computation) {
        Expression expression = computation.getExpression();
        Type expectedType = computation.getType();
        checkExpectedType(expression, expectedType);
        expression.accept(this);
    }

    private void checkCondition(Expression expression) {
        checkExpectedType(expression, new BooleanType());
        expression.accept(this);
    }

    private void checkComparison(Binary expression) {
        checkNumeric(expression);
    }

    private void checkLogical(Binary expression) {
        checkExpectedType(expression.getLeftHS(), new BooleanType());
        checkExpectedType(expression.getRightHS(), new BooleanType());
        checkBinary(expression);
    }

    private void checkEquality(Binary expression) {
        checkExpectedType(expression.getLeftHS(),
                expression.getRightHS().getType(idTypeStore));
        checkBinary(expression);
    }

    private void checkNumeric(Binary expression) {
        checkExpectedType(expression.getLeftHS(), new IntegerType());
        checkExpectedType(expression.getRightHS(), new IntegerType());
        checkBinary(expression);
    }

    private void checkUnary(Unary expression) {
        checkExpectedType(expression.getExpression(), expression.getType(idTypeStore));
        expression.getExpression().accept(this);
    }

    private void checkBinary(Binary expression) {
        expression.getLeftHS().accept(this);
        expression.getRightHS().accept(this);
    }

    /////////////////////////////////////////////
    // Visitor methods
    /////////////////////////////////////////////
    @Override
    public void visit(FormCollection formCollection) {
        // Nothing special (yet).
        // NOTE: should only call visit on individual forms!! (Since checking
        //   is on a per-form basis.) Otherwise, just returns.
        // TODO: proper notice if this method is called.
        return;
    }

    @Override
    public void visit(Form form) {
        form.getBody().accept(this);
    }

    @Override
    public void visit(Block block) {
        for (Statement statement : block.getStatements()) {
            statement.accept(this);
        }
    }

    @Override
    public void visit(Computation computation) {
        checkComputation(computation);
        addIdentifier(computation);
        addQuestionableLabel(computation);
    }

    @Override
    public void visit(If ifStat) {
        checkCondition(ifStat.getCondition());
        ifStat.getBody().accept(this);
    }

    @Override
    public void visit(IfElse ifElse) {
        checkCondition(ifElse.getCondition());
        ifElse.getBody().accept(this);
        ifElse.getElseBody().accept(this);
    }

    @Override
    public void visit(Question question) {
        addIdentifier(question);
        addQuestionableLabel(question);
    }

    @Override
    public void visit(Par par) {
        par.getExpression().accept(this);
    }

    @Override
    public void visit(Add add) {
        checkNumeric(add);
    }

    @Override
    public void visit(And and) {
        checkLogical(and);
    }

    @Override
    public void visit(Div div) {
        checkNumeric(div);
    }

    @Override
    public void visit(EQ eq) {
        checkEquality(eq);
    }

    @Override
    public void visit(GEQ geq) {
        checkComparison(geq);
    }

    @Override
    public void visit(GT gt) {
        checkComparison(gt);
    }

    @Override
    public void visit(LEQ leq) {
        checkComparison(leq);
    }

    @Override
    public void visit(LT lt) {
        checkComparison(lt);
    }

    @Override
    public void visit(Mul mul) {
        checkNumeric(mul);
    }

    @Override
    public void visit(Neg neg) {
        checkUnary(neg);
    }

    @Override
    public void visit(NEQ neq) {
        checkEquality(neq);
    }

    @Override
    public void visit(Not not) {
        checkUnary(not);
    }

    @Override
    public void visit(Or or) {
        checkLogical(or);
    }

    @Override
    public void visit(Pos pos) {
        checkUnary(pos);
    }

    @Override
    public void visit(Sub sub) {
        checkNumeric(sub);
    }

    @Override
    public void visit(Bool bool) {
        // Do nothing.
    }

    @Override
    public void visit(ID id) {
        // Do nothing.
    }

    @Override
    public void visit(Int integer) {
        // Do nothing.
    }

    @Override
    public void visit(Str str) {
        // Do nothing.
    }
}
