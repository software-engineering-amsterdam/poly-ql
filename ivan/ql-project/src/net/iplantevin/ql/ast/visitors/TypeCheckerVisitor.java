package net.iplantevin.ql.ast.visitors;

import net.iplantevin.ql.ast.ASTNode;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.expressions.Par;
import net.iplantevin.ql.ast.expressions.literals.Bool;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Int;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.expressions.operators.Add;
import net.iplantevin.ql.ast.expressions.operators.And;
import net.iplantevin.ql.ast.expressions.operators.Binary;
import net.iplantevin.ql.ast.expressions.operators.Div;
import net.iplantevin.ql.ast.expressions.operators.EQ;
import net.iplantevin.ql.ast.expressions.operators.GEQ;
import net.iplantevin.ql.ast.expressions.operators.GT;
import net.iplantevin.ql.ast.expressions.operators.LEQ;
import net.iplantevin.ql.ast.expressions.operators.LT;
import net.iplantevin.ql.ast.expressions.operators.Mul;
import net.iplantevin.ql.ast.expressions.operators.NEQ;
import net.iplantevin.ql.ast.expressions.operators.Neg;
import net.iplantevin.ql.ast.expressions.operators.Not;
import net.iplantevin.ql.ast.expressions.operators.Or;
import net.iplantevin.ql.ast.expressions.operators.Pos;
import net.iplantevin.ql.ast.expressions.operators.Sub;
import net.iplantevin.ql.ast.expressions.operators.Unary;
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;
import net.iplantevin.ql.ast.statements.Block;
import net.iplantevin.ql.ast.statements.Computation;
import net.iplantevin.ql.ast.statements.If;
import net.iplantevin.ql.ast.statements.IfElse;
import net.iplantevin.ql.ast.statements.Question;
import net.iplantevin.ql.ast.statements.Questionable;
import net.iplantevin.ql.ast.statements.Statement;
import net.iplantevin.ql.ast.types.BooleanType;
import net.iplantevin.ql.ast.types.IntegerType;
import net.iplantevin.ql.ast.types.Type;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.types.UndefinedType;
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
public class TypeCheckerVisitor implements IASTVisitor<Void> {
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

    /**
     * Only true if there are only errors of type DuplicateLabelError, or no
     * errors at all.
     */
    public boolean isTypeSafe() {
        for (ASTError error : errors) {
            if (!(error instanceof DuplicateLabelError)) {
                return false;
            }
        }
        return true;
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
                declareIdentifier(questionable.getName(), questionable.getType());
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
                    actualType
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
    public Void visit(FormCollection formCollection) {
        // Nothing special (yet).
        // NOTE: should only call visit on individual forms!! (Since checking
        //   is on a per-form basis.) Otherwise, just returns.
        // TODO: proper notice if this method is called.
        return null;
    }

    @Override
    public Void visit(Form form) {
        form.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(Block block) {
        for (Statement statement : block.getStatements()) {
            statement.accept(this);
        }
        return null;
    }

    @Override
    public Void visit(Computation computation) {
        checkComputation(computation);
        addIdentifier(computation);
        addQuestionableLabel(computation);
        return null;
    }

    @Override
    public Void visit(If ifStat) {
        checkCondition(ifStat.getCondition());
        ifStat.getBody().accept(this);
        return null;
    }

    @Override
    public Void visit(IfElse ifElse) {
        checkCondition(ifElse.getCondition());
        ifElse.getBody().accept(this);
        ifElse.getElseBody().accept(this);
        return null;
    }

    @Override
    public Void visit(Question question) {
        addIdentifier(question);
        addQuestionableLabel(question);
        return null;
    }

    @Override
    public Void visit(Par par) {
        par.getExpression().accept(this);
        return null;
    }

    @Override
    public Void visit(Add add) {
        checkNumeric(add);
        return null;
    }

    @Override
    public Void visit(And and) {
        checkLogical(and);
        return null;
    }

    @Override
    public Void visit(Div div) {
        checkNumeric(div);
        return null;
    }

    @Override
    public Void visit(EQ eq) {
        checkEquality(eq);
        return null;
    }

    @Override
    public Void visit(GEQ geq) {
        checkComparison(geq);
        return null;
    }

    @Override
    public Void visit(GT gt) {
        checkComparison(gt);
        return null;
    }

    @Override
    public Void visit(LEQ leq) {
        checkComparison(leq);
        return null;
    }

    @Override
    public Void visit(LT lt) {
        checkComparison(lt);
        return null;
    }

    @Override
    public Void visit(Mul mul) {
        checkNumeric(mul);
        return null;
    }

    @Override
    public Void visit(Neg neg) {
        checkUnary(neg);
        return null;
    }

    @Override
    public Void visit(NEQ neq) {
        checkEquality(neq);
        return null;
    }

    @Override
    public Void visit(Not not) {
        checkUnary(not);
        return null;
    }

    @Override
    public Void visit(Or or) {
        checkLogical(or);
        return null;
    }

    @Override
    public Void visit(Pos pos) {
        checkUnary(pos);
        return null;
    }

    @Override
    public Void visit(Sub sub) {
        checkNumeric(sub);
        return null;
    }

    @Override
    public Void visit(Bool bool) {
        // Do nothing.
        return null;
    }

    @Override
    public Void visit(ID id) {
        // Do nothing.
        return null;
    }

    @Override
    public Void visit(Int integer) {
        // Do nothing.
        return null;
    }

    @Override
    public Void visit(Str str) {
        // Do nothing.
        return null;
    }
}
