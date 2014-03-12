package net.iplantevin.ql.gui.main;

import net.iplantevin.ql.ast.LineInfo;
import net.iplantevin.ql.ast.expressions.Expression;
import net.iplantevin.ql.ast.expressions.literals.ID;
import net.iplantevin.ql.ast.expressions.literals.Str;
import net.iplantevin.ql.ast.form.Form;
import net.iplantevin.ql.ast.statements.Block;
import net.iplantevin.ql.ast.statements.Computation;
import net.iplantevin.ql.ast.statements.If;
import net.iplantevin.ql.ast.statements.IfElse;
import net.iplantevin.ql.ast.statements.Question;
import net.iplantevin.ql.ast.statements.Statement;
import net.iplantevin.ql.ast.types.BooleanType;
import net.iplantevin.ql.ast.types.IntegerType;
import net.iplantevin.ql.ast.types.StringType;
import net.iplantevin.ql.evaluation.EvaluationVisitor;
import net.iplantevin.ql.evaluation.Value;
import net.iplantevin.ql.gui.widgets.AbstractFormComponent;
import net.iplantevin.ql.gui.widgets.AbstractWidgetContainer;
import net.iplantevin.ql.gui.widgets.ComputationContainer;
import net.iplantevin.ql.gui.widgets.ContainerComponent;
import net.iplantevin.ql.gui.widgets.IfComponent;
import net.iplantevin.ql.gui.widgets.IfElseComponent;
import net.iplantevin.ql.gui.widgets.QuestionContainer;
import org.antlr.v4.runtime.misc.OrderedHashSet;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * A window for a single form. Builds itself by visiting a given Form.
 *
 * @author Ivan
 */
public class FormFrame extends FormFrameAdapter {
    private final EvaluationVisitor evaluator;
    private final JPanel topPanel;
    private final FormEventManager eventManager;
    private final Set<AbstractFormComponent> formComponents;
    private final int preferredLabelWidth = 500;
    private final Dimension preferredWidgetSize = new Dimension(150, 25);

    /**
     * Constructs a form window for the given Form.
     *
     * @param form the form to build the interface for.
     */
    public FormFrame(Form form) {
        evaluator = new EvaluationVisitor();
        topPanel = new ContainerComponent(this);
        eventManager = new FormEventManager(evaluator);
        formComponents = new OrderedHashSet();

        initUI(form);
    }

    /**
     * Creates necessary panels and sets various settings on them and on the
     * FormFrame itself. Also disables horizontal scrolling and initializes
     * the values of the active (visible) form components.
     *
     * @param form the Form to visit.
     */
    private void initUI(Form form) {
        // JFrame settings.
        setTitle(form.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // This disables horizontal scrolling (and sets a width of 850px).
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setSize(new Dimension(850, getHeight()));
                super.componentResized(e);
            }
        });

        // Scrolling pane settings.
        JScrollPane formScrollPane = new JScrollPane();
        formScrollPane.setBorder(new EmptyBorder(new Insets(5, 5, 5, 5)));
        formScrollPane.getViewport().add(topPanel);
        add(formScrollPane);

        // Adds all form elements to the top level JPanel by visiting the Form.
        topPanel.add(visit(form));

        // Initializes values of all active (visible) components.
        initValues();

        pack();
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

    /**
     * Shorthand to EvaluationVisitor method.
     */
    public Value evaluate(Expression expression) {
        return evaluator.evaluate(expression);
    }

    /**
     * Shorthand to EvaluationVisitor method.
     */
    public void storeValue(String identifier, Value value) {
        evaluator.storeValue(identifier, value);
    }

    /**
     * Shorthand to FormEventManager method.
     */
    public void subscribe(AbstractFormComponent formComponent, Set<String> ids) {
        eventManager.subscribe(formComponent, ids);
    }

    /**
     * Shorthand to FormEventManager method.
     */
    public void registerValueChange(AbstractWidgetContainer source, Value value) {
        eventManager.scheduleEvaluation(source, value);
    }

    public int getPreferredLabelWidth() {
        return preferredLabelWidth;
    }

    public Dimension getPreferredWidgetSize() {
        return preferredWidgetSize;
    }

    ////////////////////////////////////////////////////////////////////////////
    // Visitor methods overridden from FormFrameAdapter
    ////////////////////////////////////////////////////////////////////////////
    @Override
    public AbstractFormComponent visit(Form form) {
        return form.getBody().accept(this);
    }

    /**
     * The components gathered by visiting a Block node are put in a
     * ContainerComponent.
     *
     * @param block an AST Block node.
     */
    @Override
    public AbstractFormComponent visit(Block block) {
        ContainerComponent components = new ContainerComponent(this);

        for (Statement statement : block.getStatements()) {
            AbstractFormComponent component = statement.accept(this);
            formComponents.add(component);
            components.addOne(component);
        }
        return components;
    }

    @Override
    public AbstractFormComponent visit(Computation computation) {
        AbstractFormComponent component = new ComputationContainer(computation, this);
        formComponents.add(component);
        return component;
    }

    @Override
    public AbstractFormComponent visit(If ifStat) {
        AbstractFormComponent ifBody = ifStat.getBody().accept(this);
        Expression condition = ifStat.getCondition();
        return new IfComponent(ifBody, condition, this);
    }

    @Override
    public AbstractFormComponent visit(IfElse ifElse) {
        AbstractFormComponent ifBody = ifElse.getBody().accept(this);
        AbstractFormComponent elseBody = ifElse.getElseBody().accept(this);
        Expression condition = ifElse.getCondition();
        return new IfElseComponent(ifBody, elseBody, condition, this);
    }

    @Override
    public AbstractFormComponent visit(Question question) {
        AbstractFormComponent component = new QuestionContainer(question, this);
        formComponents.add(component);
        return component;
    }

    /**
     * A small demo form.
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                LineInfo lineInfo = new LineInfo(0, 0);
                List<Statement> statements = new ArrayList<Statement>();

                ID id1 = new ID("currentAge", lineInfo);
                Str label1 = new Str("\"What is your age?\"", lineInfo);
                Question question1 = new Question(id1, label1, new IntegerType(), lineInfo);
                statements.add(question1);

                ID id2 = new ID("lastName", lineInfo);
                Str label2 = new Str("\"What is your last name?\"", lineInfo);
                Question question2 = new Question(id2, label2, new StringType(), lineInfo);
                statements.add(question2);

                ID id3 = new ID("married", lineInfo);
                Str label3 = new Str("\"Are you married?\"", lineInfo);
                Question question3 = new Question(id3, label3, new BooleanType(), lineInfo);
                statements.add(question3);

                ID id4 = new ID("ownsHouse", lineInfo);
                Str label4 = new Str("\"Do you own a house?\"", lineInfo);
                Question question4 = new Question(id4, label4, new BooleanType(), lineInfo);

                Block body = new Block(statements, lineInfo);

                ID compId1 = new ID("ownsHouseComp", lineInfo);
                Str compLabel1 = new Str("\"Whether you own a house:\"", lineInfo);
                Computation computation1 = new Computation(compId1,
                        compLabel1, new BooleanType(), id4, lineInfo);

                List<Statement> statements2 = new ArrayList<Statement>();
                statements2.add(question4);
                statements2.add(body);
                statements2.add(computation1);

                Block body2 = new Block(statements2, lineInfo);

                FormFrame frame = new FormFrame(new Form("Test form", body2, lineInfo));
                frame.setVisible(true);
            }
        });
    }
}
