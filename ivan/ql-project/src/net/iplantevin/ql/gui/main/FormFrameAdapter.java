package net.iplantevin.ql.gui.main;

import net.iplantevin.ql.ast.expressions.Par;
import net.iplantevin.ql.ast.expressions.literals.Bool;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Int;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.expressions.operators.Add;
import net.iplantevin.ql.ast.expressions.operators.And;
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
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.form.FormCollection;
import net.iplantevin.ql.ast.statements.Block;
import net.iplantevin.ql.ast.statements.Computation;
import net.iplantevin.ql.ast.statements.If;
import net.iplantevin.ql.ast.statements.IfElse;
import net.iplantevin.ql.ast.statements.Question;
import net.iplantevin.ql.ast.visitors.IASTVisitor;
import net.iplantevin.ql.gui.widgets.AbstractFormComponent;

import javax.swing.*;

/**
 * Adapter for the FormFrame class to reduce the clutter of empty visit methods
 * in that class.
 *
 * @author Ivan
 */
public class FormFrameAdapter extends JFrame implements IASTVisitor<AbstractFormComponent> {
    @Override
    public AbstractFormComponent visit(FormCollection formCollection) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Form form) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Block block) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Computation computation) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(If ifStat) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(IfElse ifElse) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Question question) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Par par) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Add add) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(And and) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Div div) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(EQ eq) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(GEQ geq) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(GT gt) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(LEQ leq) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(LT lt) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Mul mul) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Neg neg) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(NEQ neq) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Not not) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Or or) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Pos pos) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Sub sub) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Bool bool) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(ID id) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Int integer) {
        return null;
    }

    @Override
    public AbstractFormComponent visit(Str str) {
        return null;
    }
}
