package net.iplantevin.ql.ast.visitors.typechecker;

import net.iplantevin.ql.ast.expressions.Par;
import net.iplantevin.ql.ast.expressions.literals.Bool;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Int;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.expressions.operators.*;
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;
import net.iplantevin.ql.ast.statements.*;
import net.iplantevin.ql.ast.types.TypeEnvironment;
import net.iplantevin.ql.ast.visitors.IQLASTVisitor;
import net.iplantevin.ql.exceptions.ExceptionCollection;

/**
 * Visits AST
 *
 * @author Ivan
 */
public class TypeCheckerVisitor implements IQLASTVisitor {
    // TODO: static shorthand constructor.
    private ExceptionCollection exceptionCollection;
    private TypeEnvironment typeEnvironment;
    private LabelCollection labelCollection;
    private ExpressionValidator expressionValidator;

    public TypeCheckerVisitor() {
        exceptionCollection = new ExceptionCollection();
        typeEnvironment = new TypeEnvironment(exceptionCollection);
        labelCollection = new LabelCollection(exceptionCollection);
        expressionValidator = new ExpressionValidator(exceptionCollection, typeEnvironment, this);
    }

    public ExceptionCollection getExceptionCollection() {
        return exceptionCollection;
    }

    public TypeEnvironment getTypeEnvironment() {
        return typeEnvironment;
    }

    public LabelCollection getLabelCollection() {
        return labelCollection;
    }

    @Override
    public void visit(FormCollection formCollection) {
        // Nothing special (yet).
        // NOTE: should only call visit on individual forms!! (Since checking
        //   is on a per-form basis.
        // TODO: proper notice if this method is called.
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
        expressionValidator.checkComputation(computation);
        typeEnvironment.addIdentifier(computation.getName(), computation.getType());
        labelCollection.addQuestionable(computation);
    }

    @Override
    public void visit(If ifStat) {
        expressionValidator.checkCondition(ifStat.getCondition());
        ifStat.getBody().accept(this);
    }

    @Override
    public void visit(IfElse ifElse) {
        expressionValidator.checkCondition(ifElse.getCondition());
        ifElse.getBody().accept(this);
        ifElse.getElseBody().accept(this);
    }

    @Override
    public void visit(Question question) {
        typeEnvironment.addIdentifier(question.getName(), question.getType());
        labelCollection.addQuestionable(question);
    }

    @Override
    public void visit(Par par) {
        par.getExpression().accept(this);
    }

    @Override
    public void visit(Add add) {
        expressionValidator.checkNumeric(add);
    }

    @Override
    public void visit(And and) {
        expressionValidator.checkLogical(and);
    }

    @Override
    public void visit(Div div) {
        expressionValidator.checkNumeric(div);
    }

    @Override
    public void visit(EQ eq) {
        expressionValidator.checkEquality(eq);
    }

    @Override
    public void visit(GEQ geq) {
        expressionValidator.checkComparison(geq);
    }

    @Override
    public void visit(GT gt) {
        expressionValidator.checkComparison(gt);
    }

    @Override
    public void visit(LEQ leq) {
        expressionValidator.checkComparison(leq);
    }

    @Override
    public void visit(LT lt) {
        expressionValidator.checkComparison(lt);
    }

    @Override
    public void visit(Mul mul) {
        expressionValidator.checkNumeric(mul);
    }

    @Override
    public void visit(Neg neg) {
        expressionValidator.checkUnary(neg);
    }

    @Override
    public void visit(NEQ neq) {
        expressionValidator.checkEquality(neq);
    }

    @Override
    public void visit(Not not) {
        expressionValidator.checkUnary(not);
    }

    @Override
    public void visit(Or or) {
        expressionValidator.checkLogical(or);
    }

    @Override
    public void visit(Pos pos) {
        expressionValidator.checkUnary(pos);
    }

    @Override
    public void visit(Sub sub) {
        expressionValidator.checkNumeric(sub);
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
