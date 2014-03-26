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
import net.iplantevin.ql.evaluation.EvaluationVisitor;
import net.iplantevin.ql.gui.formcomponents.AbstractFormComponent;
import net.iplantevin.ql.gui.formcomponents.ComputationContainer;
import net.iplantevin.ql.gui.formcomponents.ContainerComponent;
import net.iplantevin.ql.gui.formcomponents.IfComponent;
import net.iplantevin.ql.gui.formcomponents.IfElseComponent;
import net.iplantevin.ql.gui.formcomponents.QuestionContainer;
import net.iplantevin.ql.gui.formcomponents.TypeToWidget;
import org.antlr.v4.runtime.misc.OrderedHashSet;

import javax.swing.*;
import java.util.Set;

/**
 * @author Ivan
 */
public class FormFrameBuilder implements IStatementVisitor<AbstractFormComponent> {
    private final FormFrame formFrame;
    private final Set<AbstractFormComponent> formComponents;

    private FormFrameBuilder(Form form, GUIController controller) {
        formComponents = new OrderedHashSet<AbstractFormComponent>();
        EvaluationVisitor evaluator = new EvaluationVisitor();
        FormEventManager eventManager = new FormEventManager(evaluator);
        formFrame = new FormFrame(form.getName(), evaluator, eventManager);
        AbstractFormComponent topComponent = form.getBody().accept(this);
        initValues();
        formFrame.initUI(topComponent, controller);
    }

    public FormFrame getFormFrame() {
        return formFrame;
    }

    public static FormFrame build(Form form, GUIController controller) {
        FormFrameBuilder builder = new FormFrameBuilder(form, controller);
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
        ContainerComponent containerComponent = new ContainerComponent(formFrame);

        for (Statement statement : block.getStatements()) {
            AbstractFormComponent component = statement.accept(this);
            formComponents.add(component);
            containerComponent.addOne(component);
        }
        return containerComponent;
    }

    @Override
    public AbstractFormComponent visit(Computation computation) {
        AbstractFormComponent computationContainer =
                new ComputationContainer(computation.getIdentifier().getName(),
                        computation.getLabel().getText(),
                        computation.getExpression(), formFrame);
        formComponents.add(computationContainer);

        return computationContainer;
    }

    @Override
    public AbstractFormComponent visit(If ifStat) {
        AbstractFormComponent ifBody = ifStat.getBody().accept(this);
        Expression condition = ifStat.getCondition();
        AbstractFormComponent ifComponent = new IfComponent(ifBody, condition, formFrame);
        formComponents.add(ifComponent);

        return ifComponent;
    }

    @Override
    public AbstractFormComponent visit(IfElse ifElse) {
        AbstractFormComponent ifBody = ifElse.getBody().accept(this);
        AbstractFormComponent elseBody = ifElse.getElseBody().accept(this);
        Expression condition = ifElse.getCondition();
        AbstractFormComponent ifElseComponent =
                new IfElseComponent(ifBody, elseBody, condition, formFrame);
        formComponents.add(ifElseComponent);

        return ifElseComponent;
    }

    @Override
    public AbstractFormComponent visit(Question question) {
        AbstractFormComponent component =
                new QuestionContainer(question.getIdentifier().getName(),
                        question.getLabel().getText(), formFrame);
        JComponent widget = TypeToWidget.makeWidget(question.getType(),
                (QuestionContainer) component);
        ((QuestionContainer) component).initUIWithWidget(widget);
        formComponents.add(component);

        return component;
    }
}
