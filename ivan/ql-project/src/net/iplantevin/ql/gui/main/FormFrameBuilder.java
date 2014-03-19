package net.iplantevin.ql.gui.main;

import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.statements.Block;
import net.iplantevin.ql.ast.statements.Computation;
import net.iplantevin.ql.ast.statements.If;
import net.iplantevin.ql.ast.statements.IfElse;
import net.iplantevin.ql.ast.statements.Question;
import net.iplantevin.ql.ast.statements.Statement;
import net.iplantevin.ql.ast.visitors.IStatementVisitor;
import net.iplantevin.ql.gui.widgets.AbstractFormComponent;
import net.iplantevin.ql.gui.widgets.ComputationContainer;
import net.iplantevin.ql.gui.widgets.ContainerComponent;
import net.iplantevin.ql.gui.widgets.IfComponent;
import net.iplantevin.ql.gui.widgets.IfElseComponent;
import net.iplantevin.ql.gui.widgets.QuestionContainer;
import org.antlr.v4.runtime.misc.OrderedHashSet;

import java.util.Set;

/**
 * @author Ivan
 */
public class FormFrameBuilder implements IStatementVisitor<AbstractFormComponent> {
    private final FormFrame formFrame;
    private final Set<AbstractFormComponent> formComponents;

    private FormFrameBuilder(Form form) {
        formComponents = new OrderedHashSet<AbstractFormComponent>();
        formFrame = new FormFrame(form.getName());
        AbstractFormComponent topComponent = form.getBody().accept(this);
        initValues();
        formFrame.initUI(topComponent);
    }

    public FormFrame getFormFrame() {
        return formFrame;
    }

    public static FormFrame build(Form form) {
        FormFrameBuilder builder = new FormFrameBuilder(form);
        return builder.getFormFrame();
    }

    /**
     * Initializes values of all active (visible) components.
     */
    public void initValues() {
        for (AbstractFormComponent component : formComponents) {
            if (component.isActive()) {
                component.initValue();
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////
    // Visitor methods
    ////////////////////////////////////////////////////////////////////////////

    /**
     * The components gathered by visiting a Block node are put in a
     * ContainerComponent.
     *
     * @param block an AST Block node.
     */
    @Override
    public AbstractFormComponent visit(Block block) {
        ContainerComponent components = new ContainerComponent(formFrame);

        for (Statement statement : block.getStatements()) {
            AbstractFormComponent component = statement.accept(this);
            formComponents.add(component);
            components.addOne(component);
        }
        return components;
    }

    @Override
    public AbstractFormComponent visit(Computation computation) {
        AbstractFormComponent component = new ComputationContainer(computation, formFrame);
        formComponents.add(component);
        return component;
    }

    @Override
    public AbstractFormComponent visit(If ifStat) {
        AbstractFormComponent ifBody = ifStat.getBody().accept(this);
        Expression condition = ifStat.getCondition();
        return new IfComponent(ifBody, condition, formFrame);
    }

    @Override
    public AbstractFormComponent visit(IfElse ifElse) {
        AbstractFormComponent ifBody = ifElse.getBody().accept(this);
        AbstractFormComponent elseBody = ifElse.getElseBody().accept(this);
        Expression condition = ifElse.getCondition();
        return new IfElseComponent(ifBody, elseBody, condition, formFrame);
    }

    @Override
    public AbstractFormComponent visit(Question question) {
        AbstractFormComponent component = new QuestionContainer(question, formFrame);
        formComponents.add(component);
        return component;
    }
}
