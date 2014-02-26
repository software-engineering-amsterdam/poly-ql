package net.iplantevin.ast.visitors.typechecker;

import net.iplantevin.ast.expressions.Par;
import net.iplantevin.ast.expressions.literals.Bool;
import net.iplantevin.ast.expressions.literals.ID;
import net.iplantevin.ast.expressions.literals.Int;
import net.iplantevin.ast.expressions.literals.Str;
import net.iplantevin.ast.expressions.operators.*;
import net.iplantevin.ast.form.Form;
import net.iplantevin.ast.form.FormCollection;
import net.iplantevin.ast.statements.*;
import net.iplantevin.ast.types.TypeEnvironment;
import net.iplantevin.ast.visitors.IQLASTVisitor;
import net.iplantevin.exceptions.ExceptionCollection;

/**
 * Visits AST
 *
 * @author Ivan
 */
public class TypeCheckerVisitor implements IQLASTVisitor {
    private ExceptionCollection exceptionCollection;
    private TypeEnvironment typeEnvironment;
    private LabelCollection labelCollection;

    public TypeCheckerVisitor() {
        exceptionCollection = new ExceptionCollection();
        typeEnvironment = new TypeEnvironment(exceptionCollection);
        labelCollection = new LabelCollection(exceptionCollection);
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
        for(Statement statement : block.getStatements()) {
            statement.accept(this);
        }
    }

    @Override
    public void visit(Computation computation) {
        typeEnvironment.addIdentifier(computation.getName(), computation.getType());
        labelCollection.addQuestionable(computation);
        // TODO: handle expression.
    }

    @Override
    public void visit(If ifStat) {
        // TODO: handle expression.
        ifStat.getBody().accept(this);
    }

    @Override
    public void visit(IfElse ifElse) {
        // TODO: handle expression.
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
    }

    @Override
    public void visit(And and) {
    }

    @Override
    public void visit(Div div) {
    }

    @Override
    public void visit(EQ eq) {
    }

    @Override
    public void visit(GEQ geq) {
    }

    @Override
    public void visit(GT gt) {
    }

    @Override
    public void visit(LEQ leq) {
    }

    @Override
    public void visit(LT lt) {
    }

    @Override
    public void visit(Mul mul) {
    }

    @Override
    public void visit(Neg neg) {
    }

    @Override
    public void visit(NEQ neq) {
    }

    @Override
    public void visit(Not not) {
    }

    @Override
    public void visit(Or or) {
    }

    @Override
    public void visit(Pos pos) {
    }

    @Override
    public void visit(Sub sub) {
    }

    @Override
    public void visit(Bool bool) {
    }

    @Override
    public void visit(ID id) {
    }

    @Override
    public void visit(Int integer) {
    }

    @Override
    public void visit(Str str) {
    }
}
